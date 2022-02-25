#include <stdio.h>

#include "main.h"

int main(){

    printf("Testing print()!\n\n");

    print(0, 10);
    printf("\nShould print 0\n");

    print(10, 10);
    printf("\nShould print 10\n");

    print(10, 16);
    printf("\nShould print A\n");

    print(10, 2);
    printf("\nShould print 1010\n");

    print(159, 16);
    printf("\nShould print 9F\n");

    print(159, 1);
    printf("\nShould print Invalid base\n");

    printf("\n\nTesting en_binaire()!\n\n");

    en_binaire(10);
    printf("\nShould print 1010\n");

    en_binaire(0);
    printf("\nShould print 0\n");

    en_binaire(100);
    printf("\nShould print 1100100\n");

    printf("All tests passed successfully!");

}