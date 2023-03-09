#include <stdio.h>
#include <string.h>

int solution(char str[]) {
	int total = 0, score = 0;
	int len = strlen(str);

	for (int i = 0; i < len; i++) {
		if (str[i] == 'O') score++;
		else score = 0;
		total += score;
	}

	return total;
}
