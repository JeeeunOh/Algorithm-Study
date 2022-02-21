#include<iostream>
#include<string>
#include<deque>
using namespace std;

deque<char> wheel[4]; // 톱니바퀴 수만큼 deque 선언

void move_wheel(int id, int dir) { //id톱니 dir방향으로 움직이기
	if (dir == -1) { //반시계방향이면 하나를 뒤로 옮김
		wheel[id].push_back(wheel[id][0]);
		wheel[id].pop_front();
	}
	else { //시계방향이면 뒤에서 앞으로 하나를 가져옴
		wheel[id].push_front(wheel[id][7]);
		wheel[id].pop_back();
	}
}

void play(int num, int dir){ //톱니 전체 움직이기
	char pre_pole = wheel[num][6]; //움직이기 전의 극
	int tmp_dir = dir;
	for (int i = num - 1; i >= 0; i--) { //움직일 톱니의 왼쪽 톱니들 움직이기
		tmp_dir *= (-1);
		if (wheel[i][2] == pre_pole)break; //극이 같으면 패스
		pre_pole = wheel[i][6]; //움직이기 전의 극 저장
		move_wheel(i, tmp_dir); //톱니 움직이기
	}
	pre_pole = wheel[num][2];
	tmp_dir = dir;
	for (int i = num + 1; i < 4; i++) { //움직일 톱니의 오른쪽 톱니들 움직이기
		tmp_dir *= (-1);
		if (wheel[i][6] == pre_pole) break; //극이 같으면 패스
		pre_pole = wheel[i][2];
		move_wheel(i, tmp_dir);
	}
	move_wheel(num, dir); //해당 톱니 움직이기
}

int main(){
	for (int i = 0; i < 4; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < str.size(); j++) wheel[i].push_back(str[j]); 
	}
	int k;
	cin >> k;
	for (int i = 0; i < k; i++) {
		int num, dir;
		cin >> num >> dir;
		play(num - 1, dir);
	}
	int plus = 1; //더할 값
	int total = 0;
	for (int i = 0; i < 4; i++) {
		if (wheel[i][0] == '1')total += plus;
		plus *= 2;
	}
	cout << total << "\n";
	return 0;
}