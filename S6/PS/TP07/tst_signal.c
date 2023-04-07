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
    signal(2, sig_handler);
    signal(11, sig_handler);
    while (1){
        if (counter >= 5){
            return 0;
        }
    }
}
