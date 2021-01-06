package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class 정렬_11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][2];
        
        for(int i=0 ; i <n ; i++) {
            d[i][0] = sc.nextInt();
            d[i][1] = sc.nextInt();
        }
        
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1],o2[1]);
                }
                else 
                    return Integer.compare(o1[0], o2[0]);
            }
        });
        
        for(int i=0 ; i< n ; i++) {
            System.out.println(d[i][0]+" "+d[i][1]);
        }
        sc.close();
    }
}

