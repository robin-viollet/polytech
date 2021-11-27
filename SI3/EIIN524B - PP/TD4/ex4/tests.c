#include <stdio.h>
#include <assert.h>
#include <string.h>

#include "main.h"

int main(){

    // Test Puissance()
    {

        char msg[13] = "HELLO, WORLD";
        char cpy[13];
        char key[] = "abcde";

        char ciphered[18] = ")'/(*MB4+7-&";

        strcpy(cpy, msg);

        xorcrypt(msg, key);

        assert(strcmp(msg, ciphered) == 0);

        xorcrypt(msg, key);

        assert(strcmp(msg, cpy) == 0);

    }

    printf("All tests have passed successfully!");

}