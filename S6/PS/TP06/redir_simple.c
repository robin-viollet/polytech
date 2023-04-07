#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <string.h>
#include <errno.h>

int main(){
    int fd = open("/dev/pts/0", O_WRONLY);
    dup2(fd, 1);
    int status = execlp("ls", "ls", "-l", NULL);
}
