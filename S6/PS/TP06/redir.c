/*							-*- coding: utf-8 -*-
 *
 * redir.c	-- Redirection fichiers
 *
 * Erick Gallesio (2012-03-09)
 * Stéphane Lavirotte (2017/03/23)
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

void usage(char *progname)
{
    fprintf(stderr, "Usage: %s direction file cmd arg ...\n", progname);
    fprintf(stderr, "       direction = R or W\n");
    exit(1);
}

int main(int argc, char *argv[])
{
	int std_fd;

    if (argc < 4) {
        usage(*argv);
    }

    int fd;

    /* Vérifier que le premier argument est bien un R ou un W */
    switch (argv[1][0]) {
    case 'R':
    case 'r':
        fd = open(argv[2], O_RDONLY);
        std_fd = 0;
        break;
    case 'W':
    case 'w':
        fd = open(argv[2], O_WRONLY | O_CREAT);
        std_fd = 1;
        break;
    default:
        usage(*argv);
    }

    dup2(fd, std_fd);

    execvp(argv[3], argv + 3);
}
