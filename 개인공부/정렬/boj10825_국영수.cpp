#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

struct person{
    string name;
    int score[3];
};

bool compare(person a, person b){
    if(a.score[0]!=b.score[0]) return a.score[0] > b.score[0];
    if(a.score[1] != b.score[1]) return a.score[1] < b.score[1];
    if(a.score[2] != b.score[2]) return a.score[2] > b.score[2];
    
    return a.name < b.name;
}

int main(){
    int n;
    cin >> n;
    vector<person> p(n);

    for(int i=0 ; i<n ; i++){
        cin >> p[i].name;
        cin >> p[i].score[0] >> p[i].score[1] >> p[i].score[2];
    }

    sort(p.begin(), p.end(), compare);

    for(int i=0 ; i<n ; i++){
        cout << p[i].name << '\n';
    }
}