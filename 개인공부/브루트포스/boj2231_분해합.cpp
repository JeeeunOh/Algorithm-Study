//본 시험에서는 solution 코드와 별도로 필요한 함수만 작성합니다.
#include <iostream>
using namespace std;

//가장 작은 생성자 리턴
int solution(int n) {
	int res=n;
	int cur=n-1;
	
	while(cur--){
		int cul=cur; // 계산
		int temp=cur;
		while(temp){
			cul+=temp%10; // 일의자리수부터 더함.
			temp/=10; // 일의자리수 삭제해서 계산 계속함.
		}
		if(cul==n) res=cur; 
	}
	return res==n? 0:res;
} 
