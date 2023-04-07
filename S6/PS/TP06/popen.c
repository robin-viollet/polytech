#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

#define BUFF_SIZE 4096

int mypopen(){
    int valve[2];
    pipe(valve);

    switch(fork()){
        case 0:
            close(valve[0]);

            dup2(valve[1], 1);
            execlp("sh", "sh", "-c", "echo test", NULL);

        default:
            wait(NULL);
            close(valve[1]);
            return valve[0];
    }
}

int main(){
    int fd = mypopen();

    char buff[BUFF_SIZE];
    int size;
    int totalSize = 0;

    while (size = read(fd, buff, BUFF_SIZE)){
        totalSize += size;
        write(1, buff, size);
    }

    close(fd);

    printf("%d bytes read.", totalSize);
}
