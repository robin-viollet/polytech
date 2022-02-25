#define CHAR_SIZE  8                        /* nombre de bits dans un char */
#define MAX_BIGSET 125                      /* nombre de cellules dans un ensemble */
#define MAX_VAL    (CHAR_SIZE * MAX_BIGSET)

typedef unsigned char BigSet[MAX_BIGSET];   /* un ensemble dans [0 .. MAX_VAL[  */

void BigSet_init(BigSet s); /* initialiser s à l'ensemble vide */
void BigSet_add(BigSet s, int i); /* ajouter i dans s */
int BigSet_is_in(BigSet s, int i); /* 0 si i ∉ s et ≠ 0 sinon */
void BigSet_print(BigSet s); /* afficher les éléments de s */
void BigSet_inter(BigSet s1, BigSet s2, BigSet res);