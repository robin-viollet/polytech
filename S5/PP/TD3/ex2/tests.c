#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    assert(palindrome("ressasser"));
    assert(palindrome("kayak"));
    assert(palindrome("X"));
    assert(!palindrome("test"));

    printf("All tests have passed successfully!");

}