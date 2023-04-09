#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct stud{
    string name;
    int korean, eng, math;
};

stud student[100000];

bool compare(stud s1, stud s2){
    if(s1.korean==s2.korean){
        if(s1.eng==s2.eng){
            if(s1.math==s2.math){ // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                return s1.name<s2.name;
            }else{ // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                return s1.math>s2.math;
            }
        }else{ // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            return s1.eng<s2.eng;
        }
    }else{ // 국어 점수가 감소하는 순서로
        return s1.korean > s2.korean;
    }

}

int main(){
    int N;

    cin >> N;

    for(int i=0 ; i<N ; i++){
        cin>>student[i].name>>student[i].korean>>student[i].eng>>student[i].math;
    }
    sort(student, student+N, compare);

    for(int i=0;i<N;i++){
        cout<<student[i].name<<endl;
    }

    return 0;


}