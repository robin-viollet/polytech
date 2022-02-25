#include "main.h"

int pow2(int n){

    return n * n;

}

void map(function f, int tab[], int n){

    for (int i = 0; i < n; ++i){

        tab[i] = (*f)(tab[i]);

    }
}