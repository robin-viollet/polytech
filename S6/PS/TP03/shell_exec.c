#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define BUFF 100

int main(int argc, char** argv){
    char str[BUFF];
    while (1){
        fgets(str, BUFF, stdin);

        int i = 0;
        int j = 0;

        for (; str[i] != '\n'; ++i){
            if (j == 0 && str[j] == ' '){
                j = i;
            }
        }

        str[i] = '\0';

        strtok(str + j, " ");
        char* arg = strtok(NULL, " ");
        char* args[] = {str, arg, NULL};

        if (strcmp(str, "exit") == 0){
            exit(0);
        } else if (strcmp(str, "cd") == 0){
            printf("Going to %s\n", arg);
            int ret = chdir(arg);
            printf("Status is %d\n", ret);
        } else {
            pid_t pid = fork();

            if (pid == 0){
                execvp(str, args);
                perror(NULL);
            }
        }
    }
}
