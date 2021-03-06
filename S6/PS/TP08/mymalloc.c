/*
 * my-malloc.c  -- Implementation de malloc, free, calloc, realloc
 *
 * Implémentation first-fit pour malloc
 *
 * Erick Gallesio (2020/04/10)
 * Stéphane Lavirotte (2020/04/16)
 */

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include "mymalloc.h"

// ======================================================================
//
//    Définition des fonctions. NE PAS MODIFIER CETTE PREMIERE PARTIE.
//
// ======================================================================


// Les fonctions internes à implémenter
void *internal_malloc(size_t size);
void  internal_free(void *ptr);
void *internal_calloc(size_t nmemb, size_t size);
void *internal_realloc(void *ptr, size_t size);


// Les fonctions externes: ces fonctions appellent les fonctions internes 
//  que vous avez à écrire en y ajoutant une trace qui est utilisée par 
//  to-html et villoc.py pour générer les .html 
void *mysbrk(intptr_t increment) {
  void *ret, *old, *tmp;
  static int first_call = 1;

  if (first_call) {
    old =sbrk(0);
    fprintf(stderr, "SYS_brk(0)                    =  %p\n", old);
    first_call = 0;
  }

  ret = sbrk(increment);
  tmp = ret +increment;
  fprintf(stderr, "SYS_brk(%p)                    = %p\n", tmp, tmp);
  return ret;
}

void *mymalloc(size_t size) {
  void *ret = internal_malloc(size);
  fprintf(stderr, "mymalloc(%ld)                     = %p\n",  size, ret);
  return ret;
}

void myfree(void *ptr) {
  internal_free(ptr);
  fprintf(stderr, "myfree(%p)                    = <void>\n", ptr);
}

void *myrealloc(void *ptr, size_t size) {
  void *ret = internal_realloc(ptr, size);
  fprintf(stderr, "myrealloc(%p, %ld)                     = %p\n",  ptr, size, ret);
  return ret;
}

void *mycalloc(size_t nmemb, size_t size) {
  void *ret = internal_calloc(nmemb, size);
  fprintf(stderr, "mycalloc(%ld, %ld)                   = %p\n",  nmemb, size, ret);
  return ret;
}


// ======================================================================
//
//    Implementation
//
// ======================================================================


/* On suppose qu'on ajoute au moins 50 Headers au minimum */
#define MIN_ALLOCATION        50

/* Pour s'aligner sur des frontieres multiples
 * de la taille du type le plus contraignant
 */
#define MOST_RESTRICTING_TYPE long double
typedef union header {                          /* Header de bloc */
    struct {
        size_t size;                            /* Taille du bloc */
        union header *ptr;                      /* bloc libre suivant */
    } info;
    MOST_RESTRICTING_TYPE dummy;        /* Ne sert qu'a provoquer un alignement */
} Header;
#define HEADER_SIZE sizeof(Header)

#define NEXT(p)                  ((p)->info.ptr)
#define SIZE(p)                  ((p)->info.size)

/* L'unité de découpage de la mémoire est la taille de Header car ça permet de gérer facilement chaînage
   Le programme appelant malloc reçoit un pointeur et utilise la mémoire comme il veut.
   BLOCKS_TO_ALLOCATE renvoie le nombre de blocks nécessaires pour le malloc demandé, en tenant compte du header */
#define BLOCKS_TO_ALLOCATE(size) (1 + (size + HEADER_SIZE - 1) / HEADER_SIZE)

static Header base   = { {0, &base} }; /* Le pointeur de départ: aucune zone allouée */
static Header *freep = &base;          /* freep pointe sur la 1ère zone libre */

/* ====================================================================== */

/* Utilisé si on n'a pas trouvé assez de place */
static void *allocate_core(size_t size)
{
    if (size < MIN_ALLOCATION){
        size = MIN_ALLOCATION;
    }

    Header* newzone = mysbrk(size * HEADER_SIZE);

    if (newzone == ((void*) -1)){
        return NULL;
    }

    newzone->info.size = size;

    internal_free(newzone + 1);
    return freep;
}

/* ====================================================================== */

void *internal_malloc(size_t size)
{
    size = BLOCKS_TO_ALLOCATE(size);
    Header* p = freep;
    Header* prev = freep;

    do {
        size_t block_size = p->info.size;
        if (block_size >= size){
            if (block_size == size){
                assert(prev != p->info.ptr);
                prev->info.ptr = p->info.ptr;
            } else {
                Header* carry = p + size;
                carry->info.size = p->info.size - size;
                carry->info.ptr = p->info.ptr;
                prev->info.ptr = carry;
                p->info.size = size;
            }

            return p + 1;
        }

        if (p->info.ptr == freep){
            void* new_zone = allocate_core(size);
            if (new_zone == NULL){
                return NULL;
            }
            p = freep;
        }
        prev = p;
    } while ((p = p->info.ptr) != freep);

    return NULL;
}

/* ====================================================================== */

void internal_free(void *ptr)
{
    if (!ptr){
        return;
    }

    Header* tofree = (Header*) ptr - 1;
    Header* prev = freep;
    Header* p = freep->info.ptr;

    while(prev->info.ptr != freep && p <= tofree){
        prev = p;
        p = p->info.ptr;
    }

    if (tofree + tofree->info.size == p){
        tofree->info.size += p->info.size;
        tofree->info.ptr = p->info.ptr;
    } else {
        tofree->info.ptr = p;
    }

    if (prev + prev->info.size == tofree){
        prev->info.size += tofree->info.size;
        prev->info.ptr = tofree->info.ptr;
    } else {
        prev->info.ptr = tofree;
    }
}

/* ====================================================================== */

void *internal_calloc(size_t nmemb, size_t size)
{
    return internal_malloc(nmemb * size);
}

void *internal_realloc(void *ptr, size_t size)
{
    Header* zone = (Header*) ptr - 1;
    size_t oldsize = zone->info.size;

    myfree(ptr);

    Header* newZone = mymalloc(size);

    while (oldsize > 0){
        *(newZone + oldsize - 1) = *((Header*) ptr + oldsize - 1);
        oldsize--;
    }

    return ptr;
}

