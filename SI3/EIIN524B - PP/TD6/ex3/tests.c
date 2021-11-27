#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    int tab[] = {1, 1, 1, 1, 1, 1};

    assert(iterate(sum, tab, 6) == 6);
    assert(iterate(mul, tab, 6) == 1);
    assert(iterate(max, tab, 6) == 1);

    printf("All tests have passed successfully!");

}