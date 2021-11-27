typedef int (*function)(int i1, int i2);

int max(int i1, int i2);
int sum(int i1, int i2);
int mul(int i1, int i2);
int iterate(function f, int tab[], int n);