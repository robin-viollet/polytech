#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    // Test strcpy
    {
        char str1[] = "test";
        char str2[] = "0000";

        assert(strcmp(str1, str2));

    }

    // Test strcmp
    {
        assert(strcmp("test", "test") == 0);
        assert(strcmp("test1", "test") == 1);
        assert(strcmp("test", "test2") == -1);
        assert(strcmp("test1", "test2") == -1);
        assert(strcmp("", "test2") == -1);
        assert(strcmp("", "") == 0);
        assert(strcmp("Polyte", "Polyteh Nie") == -1);
    }

    // Test strupper
    {
        char str[] = "test";

        strupper(str);

        assert(strcmp(str, "TEST") == 0);
    }

    printf("All tests have passed successfully!");

}