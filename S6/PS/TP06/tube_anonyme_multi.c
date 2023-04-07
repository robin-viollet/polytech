#include <unistd.h>
#include <stdlib.h>

int main(){
    int valve[2];
    pipe(valve);

    switch(fork()){
        case 0:
            char* alpha = "abcdefghijklmnopqrstuvwxyz";
            close(valve[0]);

            for (int i = 0; i < 26; i += 2){
                write(valve[1], alpha + i, 2);
                sleep(1);
            }

            close(valve[1]);
            exit(0);
    }

    switch(fork()){
        case 0:
            char* alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            close(valve[0]);

            for (int i = 0; i < 26; i += 2){
                write(valve[1], alpha + i, 2);
                sleep(2);
            }

            close(valve[1]);
            exit(0);
    }

    close(valve[1]);
    char buff[3];
    int s;
    while ((s = read(valve[0], buff, 3)) > 0){
        write(1, buff, s);
    }
    close(valve[0]);
}
