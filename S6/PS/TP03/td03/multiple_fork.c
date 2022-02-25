#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define P 10
#define N 10

int main(){

	for (int i = 0; i < P; ++i){ 
		pid_t pid = fork();
		if (pid == 0){
			for (int j = 0; j < N; ++j){
				printf("Fils %d - %d\n", i, getpid());
			}
			exit(0);
		} else if (pid != -1){
			wait(NULL);
		}
	}
}
