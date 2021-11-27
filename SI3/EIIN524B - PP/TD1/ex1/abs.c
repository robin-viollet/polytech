#include <stdio.h>

int abs(int n){

	return n >= 0 ? n : -n;

}

int main(){

	int n;

	scanf("%d", &n);

	printf("abs(%d) = %d", n, abs(n));

	return 0;

}
