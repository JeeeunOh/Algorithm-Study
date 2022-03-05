#include <cstdio>
#define INF 99999999
int cost[10][10];
int N,res;

void tsp(int pos,bool *visit,int len,int size){
	if(len > res) return;
	if(size == N) {
		if(cost[pos][0] && res > cost[pos][0]+len) res = cost[pos][0]+len;
		return;
	}
	for(int i=0;i<N;i++){
		if(!visit[i] && cost[pos][i]){
			visit[i] = true;
			tsp(i,visit,len+cost[pos][i],size+1);
			visit[i] = false;
		}
	}
}

int main(){
	bool visit[10]={false};
	res=INF;
	scanf("%d",&N);
	for(int i=0;i<N;i++) for(int j=0;j<N;j++) scanf("%d",&cost[i][j]);
	visit[0]= true;
	tsp(0,visit,0,1);
	printf("%d\n",res);
}