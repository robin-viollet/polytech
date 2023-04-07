#include <unistd.h>

#include "Exo2.h"

JNIEXPORT jlong JNICALL Java_Exo2_pid
  (JNIEnv * env, jclass c){
        return getpid();
}
