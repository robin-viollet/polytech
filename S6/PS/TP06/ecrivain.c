#include <unistd.h>
#include <fcntl.h>
#include <string.h>

#define BUFF_SIZE 4096

int main(){
    int fd = open("/tmp/my_named_pipe", O_WRONLY);

    char* buff = "Shotgun debugging can be defined as:\n\n    A process of making relatively un-directed changes to software in the hope that a bug will be perturbed out of existence. \n    Using the approach of trying several possible solutions of hardware or software problem at the same time, in the hope that one of the solutions (typically source code modifications) will work.\n\nShotgun debugging has a relatively low success rate and can be very time-consuming, except when used as an attempt to work around programming language features that one may be using improperly. When combined with domain expertise and a strong intuition for the underlying codebase, it can be a good starting point to gut-solve a buggy piece of code a few times before formally researching the corresponding error message. When used in this way, it may be a valuable technique that is faster than browsing through the Internet searching a particular error message every time.";

    write(fd, buff, strlen(buff));
}
