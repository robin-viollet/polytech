#include <stddef.h>
#include <stdio.h>
#include <malloc.h>

#include "main.h"

// TODO
void prepend_element(List* root, int n){
    if (root != NULL){

        Element* next = malloc(sizeof(Element));
        next->valeur = n;

        if (*root == NULL){

            *root = next;
            return;

        }

        while ((*root)->suivant != NULL){

            root = &(*root)->suivant;

        }

        (*root)->suivant = next;

    }
}

void append_element(List* root, int n){
    if (root != NULL){

        Element* next = malloc(sizeof(Element));
        next->valeur = n;

        if (*root == NULL){

            *root = next;
            return;

        }

        while ((*root)->suivant != NULL){

            root = &(*root)->suivant;

        }

        (*root)->suivant = next;

    }
}

int find_element(List* root, int v){
    int i = -1;
    if (root != NULL){
        while (*root != NULL){
            ++i;
            if ((*root)->valeur == v){
                return i;
            }
            root = &(*root)->suivant;
        }
    }
    return -1;
}

void delete_element(List* root, int n){
    if (root != NULL){
        if (*root != NULL && (*root)->valeur == n){
            *root = (*root)->suivant;
            return;
        }

        while (*root != NULL){
            if ((*root)->suivant != NULL && (*root)->suivant->valeur == n){
                (*root)->suivant = (*root)->suivant->suivant;
                return;
            }

            root = &(*root)->suivant;
        }
    }
}

// TODO Fix last element not being deleted
void delete_elements(List* root, int n){
    if (root != NULL){
        if (*root != NULL && (*root)->valeur == n){
            *root = (*root)->suivant;
        }

        while (*root != NULL){

            if ((*root)->suivant != NULL && (*root)->suivant->valeur == n){
                (*root)->suivant = (*root)->suivant->suivant;
            } else {
                root = &(*root)->suivant;
            }
        }

        if (*root != NULL && (*root)->valeur == n){
            *root = (*root)->suivant;
        }
    }
}

void print_list(List* root){
    while (*root != NULL){
        printf("%d->", (*root)->valeur);
        root = &(*root)->suivant;
    }

    printf("*\n");
}