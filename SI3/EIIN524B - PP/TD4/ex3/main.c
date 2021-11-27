#include "main.h"

double Puissance(double x, unsigned int n){

    double y = 1;
    double z = x;

    for (int i = 0; i < n; ++i){

        if(n & 1 << i){

            y *= z;

        }

        z *= z;

    }

    return y;

}