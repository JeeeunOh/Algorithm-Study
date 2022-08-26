int res=0;

    // for(int i=0 ; i<n ; i++){
    //     for(int j=0 ; j<n ; j++){

    //         res++;
    //         queue<pair<int, int>> q;
    //         q.push({i,j});
    //         norm[i][j]='f';


    //         while(!q.empty()){
    //             auto cur = q.front();
    //             q.pop();
    //             int cx = cur.first;
    //             int cy = cur.second;
    //             norm[cx][cy]='f';

    //             for(int i=0 ; i<4 ; i++){
    //                 int nx = cx+dx[i];
    //                 int ny = cy+dy[i];

    //                 if(nx>=0 && nx<n && ny>=0 && ny<n && norm[nx][ny]==last){
    //                     q.push({nx, ny});
    //                 }
    //             }
    //         }
    //     }
    // }