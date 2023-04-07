#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(){
    int fd = open("/dev/pts/0", O_WRONLY);

    switch (fork()){
        case 0:
            dprintf(fd, "child: pid %d, fd: %d", getpid(), fd);
            break;

        case -1:
            printf("Error\n");
            exit(1);

        default:
            dprintf(fd, "parent: pid %d, fd: %d", getpid(), fd);
            wait(NULL);
            close(fd);
            break;
    }
}
