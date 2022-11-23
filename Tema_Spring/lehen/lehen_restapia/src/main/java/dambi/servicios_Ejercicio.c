#include <stdio.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>

int main()
{
    int fd0[2], fd1[2], fd2[2], fd3[2];
    double kontua = 10000, dirua = 0, sumaS1 = 0, sumaS2 = 0;

    pid_t pidS1,  pidS2;
    pipe(fd0);  //se crea el pipe
    pipe(fd1);  //se crea el pipe
    pipe(fd2);  //se crea el pipe
    pipe(fd3);  //se crea el pipe
    pidS1  = fork();

    switch(pidS1) {
        case -1: //ERROR
            printf("No se ha podido crear el hijo...");
            exit(-1);
        case 0:
            close(fd1[1]);
            close(fd1[0]);
            while(1)
            {
                read(fd1[0], &dirua, sizeof(dirua));
            }
    }


}
