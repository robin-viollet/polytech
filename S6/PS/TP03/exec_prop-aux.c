#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char** argv){
    printf("ces buffers sont perdus\n");
    printf("exec_prop-aux\n\tpid: %d\n\targv[0]: %s\n\targv[1]: %s", getpid(), argv[0], argv[1]);
}
