#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
    printf("le fils hérite ");
    pid_t pid = fork();
    if(pid == 0){
        printf("des buffers d’E/S\n");
        return 0;
    }

    printf("après un execXX()\n");
    printf("ces buffers ne sont pas perdus");

    int status = execlp("./exec_prop-aux.exe", "exec_prop-aux", "coucou", NULL);

    printf("Ceci n'est pas affiché\n");
}
