#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    List root = NULL;

    append_element(&root, 10);
    print_list(&root);

    append_element(&root, 15161);
    print_list(&root);

    append_element(&root, 5515);
    print_list(&root);

    assert(find_element(&root, 10) == 0);

    delete_element(&root, 15161);
    print_list(&root);

    assert(find_element(&root, 15161) == -1);

    List benTen = NULL;

    append_element(&benTen, 10);
    append_element(&benTen, 10);
    append_element(&benTen, 10);
    append_element(&benTen, 10);
    append_element(&benTen, 10);
    append_element(&benTen, 10);

    delete_elements(&benTen, 10);

    print_list(&benTen);

    printf("All tests passed!");

}
