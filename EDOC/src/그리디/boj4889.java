package �׸���;

import java.io.*;
import java.util.*;

public class boj4889 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char arr[]; // �Է¹��� ���ڿ� ����
        int num = 1;

        while(true){
        	arr = br.readLine().toCharArray();
        	if(arr[0]=='-') break; //---�Է¹����� ����
        	
            Stack stack = new Stack<>();
            int cnt = 0;

            for(char d : arr){
                if(d == '{'){ //�̸�
                    stack.push(d); //���ÿ� ����ִ´�
                    continue;
                }
                // d=='}'�̰�
                if(stack.isEmpty()){ //������ ����ִٸ�
                    stack.push('{'); // }�� {�� �ٲ۰��� ����ִ´�.
                    cnt++; 
                } else stack.pop(); // ���� ������� �ʴٸ� ���� {�� ���̹Ƿ� ������. { } �ѽ��� ó���ѰͰ� ����.
            }
            cnt += (stack.size() / 2);

            System.out.println(num + ". "+cnt);
            num++;
        }
	}
}
