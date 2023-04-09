#include <iostream>
#define MAX 1000000 + 1
 
using namespace std;
 
int parent[MAX]={0};
int n;
 
int getparent(int x){
  if(parent[x]==x) return x;
  return parent[x] = getparent(parent[x]);
}
 
void merge(int sa, int sb){
  int a = getparent(sa);
  int b = getparent(sb);
 
  if(a==b) return ;
  if(a < b)
    parent[b]=a;
  else
    parent[a]=b;
}
 
bool sameparent(int sa, int sb){
  int a = getparent(sa);
  int b = getparent(sb);
  if(a==b) return true;
  else return false;
}
 
 
int main(){
  int m; cin >> n >> m;
  for(int i=0; i<=n; i++) parent[i]=i;
 
  for(int k,a,b,i=0; i<m; i++){
    scanf("%d %d %d", &k, &a, &b);
    if(k==0){
      merge(a,b);
    }else{
      bool p = sameparent(a,b);
      printf(p==true?"YES\n":"NO\n");
    }
  }
}