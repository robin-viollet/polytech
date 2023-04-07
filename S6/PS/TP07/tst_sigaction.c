#include <stdio.h>
#include <signal.h>

int counter = 0;

void sig_handler(int signum){
    switch(signum){
        case 2:
            counter++;
            break;
        default:
            counter = 0;
            break;
    }

    printf("Received signal %d\n", signum);
}

int main(){
    struct sigaction sa;
    sa.sa_handler = sig_handler;

    sigemptyset(&sa.sa_mask);
    sa.sa_flags = 0;

    sigaction(2, &sa, NULL);
    sigaction(11, &sa, NULL);
    while (1){
        if (counter >= 5){
            return 0;
        }
    }
}
