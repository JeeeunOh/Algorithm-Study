#include <iostream>
using namespace std;

int N, res=0;
int arr[101][101];

void area(int x, int y, int h){ // x,y좌표, 잠기는 높이, 영역 숫자
    if(arr[x][y]>h){ // 여기가 안전한 영역일 때
        bool flag = false;

        // 근접영역이 안전하면
        if(x>0 && arr[x-1][y]>h) flag=true; 
        else if ( y>0 && arr[x][y-1]>h) flag=true; 
        
        // 근접한 안전영역이 없으면 count 추가
        if(!flag) {
            res++;
            cout << "높이 : " << h << " (" << x << "," << y << ") : " << res << endl;
        }
    }
}

int main(){
    cin >> N;

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<N ; j++){
            cin >> arr[i][j];
        }
    }

    int max=0;

    for(int h=0 ; h<100; h++){
        res=0;
        for(int x=0 ; x<N ; x++){
            for(int y=0 ; y<N ; y++){
                area(x,y,h);
            }
        }
        if(max<res) max=res;
    }

    cout << max << endl;
}