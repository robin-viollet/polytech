#include <stdio.h>
#include <assert.h>

#include "main.h"

char equals(const BigSet set1, const BigSet set2){

    for (int i = 0; i < MAX_BIGSET; ++i){

        if (set1[i] != set2[i]){

            return 0;

        }
    }

    return 1;

}

int main(){

    BigSet e1, e2, e3;

    BigSet_init(e1); BigSet_init(e2);

    for (int i = 0; i < 140; i += 12) BigSet_add(e2, i);
    for (int i = 0; i < 140; i += 9) BigSet_add(e1, i);

    BigSet_inter(e1, e2, e3);
    printf("e1 = "); BigSet_print(e1);
    printf("e2 = "); BigSet_print(e2);
    printf("e3 = "); BigSet_print(e3);

    BigSet e1r = {1, 1, 2, 4, 16, 32, 64, 128, 0, 2, 4, 8, 16, 32, 64, 128};
    BigSet e2r = {1, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132};
    BigSet e3r = {1, 0, 0, 16, 0, 0, 0, 0, 1, 0, 0, 0, 16};

    assert(equals(e1, e1));
    assert(equals(e1, e1r));
    assert(equals(e2, e2r));
    assert(equals(e3, e3r));

    printf("All tests have passed successfully!");

}