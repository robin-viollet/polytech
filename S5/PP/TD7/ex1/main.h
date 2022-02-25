struct element {
    int valeur;
    struct element *suivant;
};

typedef struct element Element;

void push_item(Element** root, int n);
Element* pop_item(Element** root);
int top_value(Element* root);
void print_stack(Element* root);