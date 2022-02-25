#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    assert(indice("Test", 'T') == 0);
    assert(indice("Test", 't') == 3);
    assert(indice("Test", 'z') == -1);
    assert(indice("Tester", 'e') == 1);

    assert(indice_droite("Test", 'T') == 0);
    assert(indice_droite("Test", 't') == 3);
    assert(indice_droite("Test", 'z') == -1);
    assert(indice_droite("Tester", 'e') == 4);

    printf("All tests passed successfully!");

}