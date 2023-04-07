#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/syscall.h>
#include <sys/types.h>

#include <pthread.h>

void* fn_thread(void *arg){
    for (int i = 0; i < 5; ++i){
        printf("PID: %d, ID thread: %ld, Linux Thread ID: %d\n", getpid(), (long) pthread_self(), syscall(SYS_gettid));
        sleep(*((int*) arg));
    }
}

int main(int argc, char** argv){
    if (argc < 3){
        printf("Not enough parameters.\n");
    }

    int n1 = atoi(argv[1]);
    int n2 = atoi(argv[2]);

    printf("PID: %d\n", getpid());

    pthread_t th1;
    int status1;
    pthread_t th2;
    int status2;

    pthread_create(&th1, NULL, fn_thread,&n1);
    pthread_create(&th2, NULL, fn_thread,&n2);

    pthread_join(th1, (void*) &status1);
    pthread_join(th2, (void*) &status2);

    printf("t1: %d, t2: %d\n", status1, status2);
}
