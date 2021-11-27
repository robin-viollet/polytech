#include <stdarg.h>
#include "main.h"

float moyenne(int count, ...){

    va_list args;
    va_start(args, count);

    int sum = 0;

    for (int i = 0; i < count; ++i){

        sum += va_arg(args, int);

    }

    va_end(args);

    return (float) sum / (float) count;

}