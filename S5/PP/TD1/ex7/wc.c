#include <stdio.h>

int main(){

	int lineNum = 0;
	int wordNum = 0;
	int charNum = 0;

	int c;

	char blank = 0;

	while ((c = getchar()) != EOF){

		charNum++;

		if (c == '\n' || c == '\t' || c == ' '){

			if (!blank){

				wordNum++;
				blank = 1;			

			}

		} else {

			blank = 0;

		}

		if (c == '\n'){

			lineNum++;

		}
	}

	printf("lines: %d\nwords: %d\nchars: %d", lineNum, wordNum, charNum);

}
