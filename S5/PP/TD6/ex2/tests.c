#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    int tab[] = {1, 2, 3 , 4, 5};

    int restab[] = {1, 4, 9 , 16, 25};

    map(pow2, tab, 5);

    for (int i = 0; i < 5; ++i){

        assert(tab[i] == restab[i]);

    }

    printf("All tests have passed successfully!");

}