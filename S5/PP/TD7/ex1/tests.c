#include <stdio.h>
#include <assert.h>

#include "main.h"

int main(){

    Element* root = NULL;

    push_item(&root, 10);

    print_stack(root);

    push_item(&root, 15161);

    print_stack(root);

    push_item(&root, 5515);

    print_stack(root);

    Element* item = pop_item(&root);

    assert(item->valeur == 5515);

    print_stack(root);

    assert(top_value(root) == 15161);

    printf("All tests passed!");

}
