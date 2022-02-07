#include <stdlib.h>
#include <stdio.h>
#include <dlfcn.h>

#include "load_library.h"

void (*sortfn)(int list[], int size);

void sort(int list[], int size){
	(*sortfn)(list, size);
}

void load_library(char *library_name){
	void *handle;
	char *error;
	handle = dlopen(library_name, RTLD_LAZY);
	if (!handle){
		fprintf(stderr, "%s\n", dlerror());
		exit(1);
	}

	dlerror();

	sortfn = (void (*)(int*, int)) dlsym(handle, "sort");

	error = dlerror();
	if (error != NULL){
		fprintf(stderr, "%s\n", error);
		exit(1);
	}

	dlclose(handle);
}
