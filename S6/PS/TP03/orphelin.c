#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
    pid_t pid = fork();
    if(pid == 0){
        pid_t ppid = getppid();
        while (getppid() == ppid){
            sleep(1);
        }
        printf("ppid changed from %d to %d", ppid, getppid());
    }
}
