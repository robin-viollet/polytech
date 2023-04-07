#include "Exo3.h"

#include <unistd.h>

JNIEXPORT jint JNICALL Java_Exo3_fork
  (JNIEnv *, jclass){
        return fork();
}
