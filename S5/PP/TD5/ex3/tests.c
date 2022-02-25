#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    assert(evaluer('+', 1, 2, 3, -1) == 6);
    assert(evaluer('-', 10, evaluer('*', 2, 2, 2, -1), 2, -1) == 0);

    printf("All tests have passed successfully!");

}