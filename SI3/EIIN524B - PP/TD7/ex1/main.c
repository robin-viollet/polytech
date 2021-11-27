#include <stddef.h>
#include <stdio.h>
#include <malloc.h>

#include "main.h"

void push_item(Element** root, int n){
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

Element* pop_item(Element** root){
    while ((*root)->suivant != NULL){
        root = &(*root)->suivant;
    }

    Element* element = *root;
    *root = NULL;

    return element;
}

int top_value(Element* root){
    while (root->suivant != NULL){
        root = root->suivant;
    }

    return root->valeur;
}

void print_stack(Element* root){
    while (root != NULL){
        printf("%d->", root->valeur);
        root = root->suivant;
    }

    printf("*\n");
}