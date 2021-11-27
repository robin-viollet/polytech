#include <stddef.h>
#include <stdio.h>
#include <malloc.h>

#include "main.h"

// TODO
void prepend_element(List root, int n){
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

void append_element(List root, int n){
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

int find_element(List root, int v){
    int i = -1;
    if (root != NULL){
        while ((*root)->suivant != NULL){
            if ((*root)->valeur == v){
                break;
            }
            root = &(*root)->suivant;
            ++i;
        }
    }
    return i;
}

void delete_element(List root, int n){
    while ((*root)->suivant != NULL){
        root = &(*root)->suivant;
    }



    Element* element = *root;
    *root = NULL;
}

void delete_elements(List root, int n){
    while ((*root)->suivant != NULL){
        root = &(*root)->suivant;
    }

    Element* element = *root;
    *root = NULL;
}

void print_list(List root){
    while (root != NULL){
        printf("%d->", (*root)->valeur);
        root = &(*root)->suivant;
    }

    printf("*\n");
}