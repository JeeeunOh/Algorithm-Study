#include <stdio.h>
#include <algorithm>
#include <string.h>

using namespace std;

int main() {
    int i, cnt = 0;
    char s[101];
    scanf("%d", &i);
    while (i--) {
        scanf("%s", s);
        int len = strlen(s);
        len = unique(s, s + len) - s;
        sort(s, s + len);
        if (unique(s, s + len) == s + len) cnt++;
    }
    printf("%d", cnt);
    return 0;
}