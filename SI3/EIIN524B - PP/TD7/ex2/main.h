struct element {
    int valeur;
    struct element *suivant;
};

typedef struct element Element;
typedef Element* List;

void prepend_element(List* lst, int v);
void append_element(List* lst, int v);
void insert_element(List* lst, int v);
void delete_element(List* lst, int v);
void delete_elements(List* lst, int v);
int find_element(List* root, int v);
void print_list(List* lst);