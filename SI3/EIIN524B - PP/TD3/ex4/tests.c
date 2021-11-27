#include <stdio.h>
#include <assert.h>

#include "main.h"
#include "../ex3/main.h"

int main(){

    {
        char str[] = "Polytech Nice";

        suppress_char(str, 'c');

        assert(strcmp(str, "Polyteh Nie") == 0);
    }

    {
        char str[] = "Polytech Nice";

        suppress_char(str, 'e');

        assert(strcmp(str, "Polytch Nic") == 0);
    }

    printf("All tests have passed successfully!");

}