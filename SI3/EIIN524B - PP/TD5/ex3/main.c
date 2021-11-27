#include <stdio.h>
#include <stdarg.h>
#include "main.h"

int evaluer(char operateur, int operande, ...){

    va_list args;
    va_start(args, operande);

    int result;

    switch (operateur){
        case '+':
            result = operande;

            while ((operande = va_arg(args, int)) >= 0){

                result += operande;

            }

            break;
        case '-':
            result = operande;

            while ((operande = va_arg(args, int)) >= 0){

                result -= operande;

            }

            break;
        case '*':
            result = operande;

            while ((operande = va_arg(args, int)) >= 0){

                result *= operande;

            }
            break;
        case '/':
            result = operande;

            while ((operande = va_arg(args, int)) > 0){

                result /= operande;

            }
            break;

        default:
            printf("Error!");
            return 0;
    }

    return result;

}