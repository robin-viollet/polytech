#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    // Test Puissance()
    {

        assert(Puissance(10, 4) == 10000);
        assert(Puissance(4, 4) == 256);
        assert(Puissance(2, 10) == 1024);
        assert(Puissance(10, 1) == 10);

    }

    printf("All tests have passed successfully!");

}