#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    //Element* root = NULL;
    List root = NULL;

    append_element(root, 10);

    print_list(root);

    append_element(root, 15161);

    print_list(root);

    append_element(root, 5515);

    print_list(root);

    assert(find_element(root, 10) == 0);
    delete_element(root, 15161);

    assert(find_element(root, 15161) == -1);

    print_list(root);

    printf("All tests passed!");

}
