#include <unistd.h>

void lecture(int fd){
    char c;
    while (read(fd, &c, 1) > 0){
        write(1, &c, 1);
    }
}

int main(){
    int valve[2];
    pipe(valve);

    write(valve[1], "0123456789", 11);
    close(valve[1]);

    lecture(valve[0]);
}
