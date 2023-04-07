#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <string.h>

#define BUFF_SIZE 4096

int copy(int srcFd, int dstFd){
    char buff[BUFF_SIZE];
    ssize_t nread;

    while ((nread = read(srcFd, buff, BUFF_SIZE)) > 0){
        write(dstFd, buff, nread);
    }

    if (nread == -1){
        return -1;
    }

    return 0;
}

int main(int argc, char** argv){
    if (argc < 3){
        printf("Usage: %s source dest\n", *argv);
        printf("Usage: %s sources... dir\n", *argv);
        exit(1);
    }

    if (argc > 3){
        // Copy files to dir
        const char* dst = argv[argc - 1];
        int dstFd = open(dst, O_DIRECTORY);

        if (dstFd == -1){
            printf("Can't open directory %s\n", dst);
            exit(1);
        }

        for (int i = 1; i < argc - 1; ++i){
            const char* src = argv[i];
            int srcFd = open(src, O_RDONLY);
            const char* basename = strrchr(src, '/');
            basename = (basename == NULL) ? src : (basename + 1);

            char file[strlen(dst) + 1 + strlen(basename)];
            file[0] = '\0';
            strcat(file, dst);
            strcat(file, "/");
            strcat(file, basename);
            int fileFd = open(file, O_CREAT | O_WRONLY, S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH);
            printf("Copying %s to %s\n", src, file);

            if (copy(srcFd, fileFd) == -1){
                printf("Can't read file %s\n", src);
            }

            close(srcFd);
            close(fileFd);
        }

        close(dstFd);
    } else {
        // Overwrite file
        const char* src = argv[1];
        const char* dst = argv[2];

        int srcFd = open(src, O_RDONLY);
        int dstFd = open(dst, O_WRONLY | O_CREAT);

        if (srcFd == -1){
            printf("Unable to open file %s\n", src);
            exit(1);
        }

        if (dstFd == -1){
            printf("Unable to open file %s\n", dst);
            exit(1);
        }

        printf("Copying %s to %s\n", src, dst);

        if (copy(srcFd, dstFd) == -1){
            printf("Can't read file %s\n", src);
        }

        close(srcFd);
        close(dstFd);
    }

    exit(0);
}
