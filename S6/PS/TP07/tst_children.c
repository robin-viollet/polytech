#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <signal.h>

int child1 = 0;
int child2 = 0;

void child1_hand(int signum){
    child1 = 1;
}

void child2_hand(int signum){
    child2 = 1;
}

int main(){
    pid_t pid = fork();

    struct sigaction sa;

    sigemptyset(&sa.sa_mask);
    sa.sa_flags = 0;

    sa.sa_handler = child1_hand;
    sigaction(SIGUSR2, &sa, NULL);

    sa.sa_handler = child2_hand;
    sigaction(SIGUSR1, &sa, NULL);

    switch(pid){
        case 0:
            while(!child1){
                sleep(1);
            }

            printf("Child 1 out.\n");
            return 0;

    }

    pid_t pid2 = fork();

    switch (pid2){
        case 0:
            while(!child2){
                sleep(1);
            }

            kill(pid, SIGUSR2);
            printf("Child 2 out.\n");
            return 0;
    }

    kill(pid2, SIGUSR1);

    wait(NULL);
    wait(NULL);

    printf("Out.\n");
}
