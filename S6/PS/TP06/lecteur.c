#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>

#define BUFF_SIZE 4096

int main(){
    char* path = "/tmp/my_named_pipe";
    int errno;
    if (!(errno = mkfifo(path, 0666))){
        int fd = open(path, O_RDONLY);

        char buff[BUFF_SIZE];
        int size;

        while ((size = read(fd, buff, BUFF_SIZE)) > 0){
            write(1, buff, size);
        }
    } else {
        printf("Error: %s\n", strerror(errno));
    }
}
