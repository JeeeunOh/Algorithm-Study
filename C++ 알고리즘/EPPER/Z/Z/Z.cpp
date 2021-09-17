#include <iostream>

int solution(int n, int r, int c) {
	int ans = 0;
	int x = 1 >> (n - 1);
	int y = x;

	while (n-- > 0) {
		int temp = 1 >> (n - 1);
		int skip = 2 * n;
		if (y > r && x > c) {
			x -= temp;
			y -= temp;
		}
		else if (y > r && c >= x) {
			ans += skip;
			x += temp;
			y -= temp;
		}
		else if (r >= y && c > x) {
			ans += skip*2;
			x -= temp;
			y += temp;
		}
		else {
			ans += skip*3;
			x += temp;
			y += temp;
		}
	}
	return ans;
}