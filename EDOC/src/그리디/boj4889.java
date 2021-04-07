package 그리디;

import java.io.*;
import java.util.*;

public class boj4889 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char arr[]; // 입력받은 문자열 저장
        int num = 1;

        while(true){
        	arr = br.readLine().toCharArray();
        	if(arr[0]=='-') break; //---입력받으면 종료
        	
            Stack stack = new Stack<>();
            int cnt = 0;

            for(char d : arr){
                if(d == '{'){ //이면
                    stack.push(d); //스택에 집어넣는다
                    continue;
                }
                // d=='}'이고
                if(stack.isEmpty()){ //스택이 비어있다면
                    stack.push('{'); // }를 {로 바꾼것을 집어넣는다.
                    cnt++; 
                } else stack.pop(); // 스택 비어있지 않다면 앞은 {일 것이므로 빼낸다. { } 한쌍을 처리한것과 같다.
            }
            cnt += (stack.size() / 2);

            System.out.println(num + ". "+cnt);
            num++;
        }
	}
}
