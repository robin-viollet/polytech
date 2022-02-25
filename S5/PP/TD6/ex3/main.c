#include "main.h"

int max(int i1, int i2){
    return i1 > i2 ? i1 : i2;
}

int sum(int i1, int i2){
    return i1 + i2;
}

int mul(int i1, int i2){
    return i1 * i2;
}

int iterate(function f, int tab[], int n){
    int res = tab[0];

    for (int i = 1; i < n; ++i){

        res = (*f)(res, tab[i]);

    }

    return res;
}