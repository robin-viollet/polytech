#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

#define BUFF 100

void my_system(char* s){
    pid_t pid = fork();

    if (pid == 0){
        execlp(s, s, (char *) NULL);
        perror(NULL);
    } else {
        wait(NULL);
    }
}

int main(int argc, char** argv){
    char str[BUFF];
    while (1){
        printf("$ ");
        fflush(stdout);
        fgets(str, BUFF, stdin);

        int i = 0;
        int j = 0;

        for (; str[i] != '\n'; ++i){
            if (j == 0 && str[i] == ' '){
                j = i;
            }
        }

        if (j == 0){
            j = i;
        }

        str[i] = '\0';

        char* arg = strtok(str + j, " ");
        char* args[] = {str, arg, NULL};

        if (strncmp(str, "exit", j) == 0){
            exit(0);
        } else {
            int r = strncmp(str, "cd", j);
            if (r == 32 || r == 0){
                printf("Going to %s %d %d\n", arg, i, j);
                int ret;
                if (i == j){
                    ret = chdir(getenv("HOME"));
                } else {
                    ret = chdir(arg);
                }
                printf("Status is %d (%d)\n", ret, errno);
            } else {
                my_system(str);
            }
        }
    }
}
