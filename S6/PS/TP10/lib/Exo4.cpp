#include "Exo4.h"

#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

JNIEXPORT jint JNICALL Java_Exo4_fork
  (JNIEnv *, jclass){
        return fork();
}

JNIEXPORT void JNICALL Java_Exo4_waitD
  (JNIEnv *, jclass){
      wait(NULL);
}

JNIEXPORT void JNICALL Java_Exo4_exit
  (JNIEnv *, jclass){
      exit(0);
}

JNIEXPORT void JNICALL Java_Exo4_sleep
  (JNIEnv *, jclass, jint s){
      sleep(s);
}

JNIEXPORT jlong JNICALL Java_Exo4_pid
  (JNIEnv * env, jclass c){
        return getpid();
}
