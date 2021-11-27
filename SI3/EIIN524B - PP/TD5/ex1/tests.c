#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    assert(moyenne(3, 10, 10, 10) == 10);
    assert(moyenne(4, 1, 2, 3, 4) == 2.5);

    printf("All tests passed!");

}