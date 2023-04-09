package EPPER;

import java.util.*;

public class ex15_7 {
	  public static int solution(int s[], int e[], int num){      
	      int answer = 0, N = num; // N�� �л� ��
	      int i, j, tmp, e1 = -1, e2 = -1; // e1, e2�� �� �ڸ��� �ǹ��մϴ�.
	      
	      for(i = 0; i < N; i++){ // �л����� ����ð� ������������ �����մϴ�.
	          for(j = 0; j < N - 1; j++){ // ���� ���̽��� ���۽ð� ���������Դϴ�.
	              if((e[j] > e[j + 1]) || (e[j] == e[j + 1] && s[j] > s[j + 1])){ 
	                  // ���� ����, ����� ���� �л��� �ð��� ��ȯ�մϴ�.
	                  tmp = s[j];
	                  s[j] = s[j + 1];
	                  s[j + 1] = tmp;
	                  tmp = e[j];
	                  e[j] = e[j + 1];
	                  e[j + 1] = tmp;
	              }
	          }
	      }
	      
	      for(i = 0; i < N; i++){
	          if(e1 <= s[i]){ // 1�� �ڸ��� ����ִٸ� �л��� �Ҵ��մϴ�.
	              e1 = e[i]; // 1�� �ڸ��� �л��� ���� �ð��� �����մϴ�.
	              answer++; // �л��� 1�� �Ҵ� �Ǿ����� ++�� ����Ͽ� answer += 1 �� �մϴ�.
	          }else if(e2 <= s[i]){ // 2�� �ڸ��� ��� �ִٸ� �л��� �Ҵ��մϴ�.
	              e2 = e1; // �̹� �ڸ��� �Ҵ�� �л��� ���� �ð��� �����մϴ�.
	              e1 = e[i]; // 1�� �ڸ��� �л��� ���� �ð��� �����մϴ�.
	              answer++; // �л��� 1�� �Ҵ� �Ǿ����� ++�� ����Ͽ� answer += 1 �� �մϴ�.
	          }
	      }
	      
	      return answer; // �л��� �Ҵ�� Ƚ���� ������ answer�� ��ȯ�մϴ�.
	  }
	  
	  public static void main(String args[]) {
		  Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt();
		  
		  int s[] = new int[N];
		  int e[] = new int[N];
		  for(int i=0 ; i<N ; i++) s[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) e[i]=sc.nextInt();
		  
		  System.out.println(solution(s, e, N));
	  } 
	}
