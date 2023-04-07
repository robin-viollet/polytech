#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <pthread.h>

#include "timer.h"

#define NPROCESS 100

void wait_processus(int); // Définition du prototype de fonction pour l'utiliser

void *fn_thread(void *arg) {
  sleep(1);
  pthread_exit((void *) 1);
  return NULL;
}

long create_processus(int n) {
	struct timespec vartime = timer_start(); /* Démarrage de la mesure temporelle */
	pthread_t th;
	
    /* Création de n processus s'exécutant en parallèle */
    for (int i = 0; i < n; ++i) {
		pthread_create(&th, NULL, fn_thread, NULL);
	}
	/* On mesure le temps écoulé pour la création des n processus */
	long time = timer_end(vartime);

    /* On attend pour pouvoir contaster la création des processus avec htop (mais ne compte pas dans le temps mesuré */
	sleep(10);

	/* On attend la fin des processus créés par mesure sociale et pour éviter un impact sur les prochaine mesures */
	//wait_processus(n);

	return time; /* Retourne le temps écoulé pour réaliser la création des n processus */
}

void wait_processus(int n) {
    /* Mesure de salubrité sociale, le père attend la fin de tous ses fils */
    for (int i = 0; i < n; ++i) 
		wait(NULL);
}

int main(int argc, char *argv[]) {
	int n = NPROCESS;

    for (int i = 1; i < argc; i++) {
		if (argv[i][0] != '-') {
			n = atoi(argv[i]);
		}
	}
	
	long time_processus = create_processus(n);
	
	printf("Time taken for creating %d processus (nanoseconds): %ld\n", n, time_processus);
	printf("Time taken for creating %d processus (milliseconds): %ld\n", n, time_processus / NANO_TO_MILLI);

    /* On flushe la sortie standard */
    fflush(stdout);

    /* Fin du père */
    exit(0);
}

