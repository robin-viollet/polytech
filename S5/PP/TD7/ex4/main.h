struct node {
    int value;
    struct node *left;
    struct node *right;
};

typedef struct node *tree;

tree create_empty_tree(void);  // créer un nouvel arbre vide

tree add_tree(tree t, int v);  // ajouter v dans l'arbre t. Cette fonction renvoie
// l'arbre dans lequel v a été ajouté.`{.c}

void print_tree(tree t);       // afficher l'arbre t (dans l'ordre)

tree find_tree(tree t, int v); // Renvoyer l'arbre de racine v (NULL si absent)

void free_tree(tree t);        // Libérer l'espace occupé par t