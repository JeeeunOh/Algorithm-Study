
            v[i][j] = max(v[i-1][j], v[i][j-1]);

            if(a[i-1]==b[j-1]){