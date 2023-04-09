package EPPER;

import java.util.*;

class ex14_5 {
	public static int k,n;
		public static class Word implements Comparable<Word>{
			 String word;
			 int count; //������ Ƚ��
			 
			 public Word(String word) {
			     this.word = word;
			     this.count = 0;
			 }
			
			 @Override
			 public int compareTo(Word o) {
				 int size1 = this.word.length();
				 int size2 = o.word.length();
				 int size = Math.min(size1, size2);

				 if(this.count > o.count) {
			            return 1; //  �ܾ� ������ ���ؼ��� ��������
			        }else if (this.count < o.count) return -1;
			        else {
			        	for(int i=1; i<size; i++) {
							if(this.word.charAt(i)<o.word.charAt(i))
								return -1;
							else if(this.word.charAt(i)>o.word.charAt(i))
								return 1;
							
						}
			        }
			     return 0;
			 }
		}

	public static String[] solution(String[] words, String[] user_inputs){
					int len_w = words.length;
					int len_in = user_inputs.length;
					
					Word[] arr = new Word[len_w]; // �Է¹��� ������� �迭
					String[] answer = new String[len_in];
					
					// word string�� �������
					for(int i=0 ; i<len_w ; i++)  arr[i]=new Word(words[i]); 
					
					for(int i=0 ; i<len_in ; i++) {
						Arrays.sort(arr);
						for(int j=0 ; j<len_w ; j++) {
							if(arr[j].word.charAt(0)==user_inputs[i].charAt(0)) { // ���� �ձ��ڿ� �Է¹��� ���ĺ��� ��ġ�Ѵٸ�
								answer[i]=arr[j].word;
								arr[j].count++; // count �÷���
								break;
							}
						}
					}
					return answer;
		}
		
	 public static void main(String[] args) throws Exception {
	     Scanner sc = new Scanner(System.in);
	     
	     // k, n �Է¹ޱ�
	     k = sc.nextInt();
	     n = sc.nextInt();
	     sc.nextLine();
	     String[] words = new String[k];
	     String[] user_inputs = new String[n];
	     
	     // �̸� �־����� �ܾ� �Է� �ޱ�
	     for(int i = 0; i < k; i++) words[i] = sc.nextLine();
	     for(int i = 0; i < n; i++) user_inputs[i] = sc.nextLine();
				
	     String[] answer = solution(words, user_inputs);
				
	     for(String ans : answer) System.out.println(ans);
	 }
}

