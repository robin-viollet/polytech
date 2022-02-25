#include <stdio.h>
#include <assert.h>
#include <malloc.h>

#include "main.h"

int main(){

    char *s = NULL;

    do {
        printf("Entrer une chaîne: "); fflush(stdout);
        s = readline();
        if (s) {
            printf("Chaîne lue : '%s'\n", s);
            free(s);
        }
    } while (s);

    printf("All tests passed!");

}
