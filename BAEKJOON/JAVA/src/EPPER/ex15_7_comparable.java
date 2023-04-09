package EPPER;

// ���� ȸ�ǽ� ������ �Ȱ��� ����

import java.util.*; 

public class ex15_7_comparable {
	public static class Person implements Comparable<Person>{
		int start; // ���۽ð�
		int end; // �����½ð�
		public Person(int start, int end) {
			this.start=start;
			this.end=end;
		}
		 @Override
		 // ����ð� �������� ���� �� ������ ���۽ð� ��������
		    public int compareTo(Person p){
		    	if(this.end!=p.end)  return this.end-p.end; 
		    	else  return this.start-p.start;
		    }
	}
	
	  public static int solution(Person p[], int num){      
	      int answer = 0, N = num; 
	      int i, j, tmp, e1 = -1, e2 = -1;
	      
	      Arrays.sort(p); // ������ ���� ���Ѵ�� ����
	      
	      for(i = 0; i < N; i++){
	          if(e1 <= p[i].start){ // 1�� �¼� ����ִٸ�, 
	              e1 = p[i].end; // �̿� ������ �ð��� �ش��л� ������ �ð����� �缳��
	              answer++;
	          }else if(e2 <= p[i].start){ //1�� �¼��� �� ���� ��, 2�� �¼��� ����ִٸ�
	        	  // e2=p[i].end �� ������
	        	  e2 = e1; 
	              e1 = p[i].end; //2���¼��� ��� ����ְ�, 1���� 2�� �¼� ����� �ٲ�
	  			//������ ���� �л����� �޾ƾ��ϱ� ������ e2�� e1�� �л����� ���� �ٲٵ��� �Ѵ�.
	  			//�ٲ��� ������ ����1�� ��� e1���� s:0, e:3�� �л��� ������ s:6, e:7�� �л��� ���� �л��� 3�� ���� �� �ְ� �ȴ�.
	              answer++;
	          }
	      }
	      return answer; 
	  }
	  
	  public static void main(String args[]) {
		  Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt();
		  
		  int s[] = new int[N];
		  int e[] = new int[N];
		  Person[] p = new Person[N];
		  for(int i=0 ; i<N ; i++) s[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) e[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) p[i]=new Person(s[i], e[i]);
		  
		  System.out.println(solution(p, N));
	  } 
	}
