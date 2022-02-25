#include <stdio.h>

#include "main.h"

int main(){

    tree t = create_empty_tree();

    // Création de l'arbre du sujet
    t = add_tree(t, 8);
    t = add_tree(t, 3);
    t = add_tree(t, 10);
    t = add_tree(t, 1);
    t = add_tree(t, 6);
    t = add_tree(t, 7);
    t = add_tree(t, 4);
    t = add_tree(t, 14);
    t = add_tree(t, 13);

    // Impression de l'arbre (trié)
    printf("Valeurs dans l'arbre: ");
    print_tree(t);
    printf("\n");

    // Recherches
    printf("\nRecherches:\n");
    for (int i = 0; i < 20; i ++) {
        printf("%2d: %s, ", i, find_tree(t, i)? "oui": "non");
        if (i % 5 == 4) printf("\n");
    }

    // Free
    printf("\nLibération mémoire de l'arbre:\n");
    free_tree(t);

    printf("All tests passed!");

}
