#include <stdio.h>

int main(){

	int n = 0;
	int i = 0;

	while (n >= 0){

		printf("Entrer un entier: ");
		scanf("%d", &n);
		++i;

	}

	printf("Nombre d'entiers saisis: %d", i - 1);

	return 0;

}
