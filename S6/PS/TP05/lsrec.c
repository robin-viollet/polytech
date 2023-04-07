#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <dirent.h>
#include <pwd.h>
#include <grp.h>
#include <time.h>
#include <ctype.h>

void print_perm(struct stat pathspec){
    printf("%c%c%c%c%c%c%c%c%c",
           pathspec.st_mode & S_IRUSR ? 'r' : '-', pathspec.st_mode & S_IWUSR ? 'w' : '-', pathspec.st_mode & S_IXUSR ? 'x' : '-',
           pathspec.st_mode & S_IRGRP ? 'r' : '-', pathspec.st_mode & S_IWGRP ? 'w' : '-', pathspec.st_mode & S_IXGRP ? 'x' : '-',
           pathspec.st_mode & S_IROTH ? 'r' : '-', pathspec.st_mode & S_IWOTH ? 'w' : '-', pathspec.st_mode & S_IXOTH ? 'x' : '-');
}

void print_date(struct stat pathspec){
    char dom[3];
    char moy[10];
    char time[6];
    time_t t = pathspec.st_atime;
    struct tm lt;
    localtime_r(&t, &lt);
    strftime(dom, 3, "%d", &lt);
    strftime(moy, 10, "%B", &lt);
    strftime(time, 6, "%R", &lt);
    moy[0] = tolower(moy[0]);

    printf(" %s %s %s", dom, moy, time);
}

void print_fileinfo(const char* path, struct stat pathspec){
    printf("%c", S_ISDIR(pathspec.st_mode) ? 'd' : '-');
    print_perm(pathspec);
    struct passwd* user = getpwuid(pathspec.st_uid);
    struct group* group = getgrgid(pathspec.st_gid);

    printf(" %d %s %s %4d", pathspec.st_nlink,
           user->pw_name, group->gr_name,
           pathspec.st_size);
    print_date(pathspec);
    printf(" %s\n", path);
}

void list(const char* path){
    struct stat pathspec;
    int status = stat(path, &pathspec);

    if (S_ISDIR(pathspec.st_mode)){
        DIR* parent = opendir(path);

        printf("%s:\n", path);

        struct dirent* entry;

        while (entry = readdir(parent)){
            char* entryname = entry->d_name;
            char entrypath[strlen(path) + 1 + strlen(entryname)];
            *entrypath = 0;
            strcat(entrypath, path);
            strcat(entrypath, "/");
            strcat(entrypath, entryname);

            print_fileinfo(entrypath, pathspec);
        }

        rewindir(entry);

        while (entry = readdir(parent)){
            char* entryname = entry->d_name;
            char entrypath[strlen(path) + 1 + strlen(entryname)];
            *entrypath = 0;
            strcat(entrypath, path);
            strcat(entrypath, "/");
            strcat(entrypath, entryname);

            if (!(entryname[0] == '.' && entryname[1] == '\0' || entryname[0] == '.' && entryname[1] == '.' && entryname[2] == '\0')){
                list(entrypath);
            }
        }

        printf("\n");

        closedir(parent);
    }
}

int main(int argc, char** argv){
    if (argc > 1){
        list(argv[1]);
    } else {
        list(".");
    }
}
