#include <stdio.h>

#include "main.h"

int main(){

    Printf("DEBUT\n%s%c c'est moi.\nTest nombres: 0x%x et %d et un négatif %d\n",
           "salut", ',', 161, 123, -12);
    Printf("Trois nombres sur la même ligne: %d %f %d\n", 1, 2.0, 3);
    Printf("Affichage d'un '%c' et encore un d'une autre façon '%%'\n", '%');
    Printf("Affichage d'un %% non suivi d'un caractère spécial ==> %z...\n");
    Printf("Attention au %% en fin de la chaîne format ==> %");
    Printf("\nFIN\n");

    printf("All tests have passed successfully!");

}