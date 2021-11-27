#include <stdio.h>

#include "main.h"

int main(){

    Debug("Utilisation de la fonction de debug");
    Debug("On peut utiliser les caractères %% de Printf");
    Debug("comme on peut le voir ici: 0x%x et %d et un négatif %d",
          161, 123, -12);
    Debug("");
    Debug("et pour finir une %s", "chaîne");

    printf("All tests have passed successfully!");

}