package EPPER;

import java.util.*;

class ex14_5 {
	public static int k,n;
		public static class Word implements Comparable<Word>{
			 String word;
			 int count; //말해진 횟수
			 
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
			            return 1; //  단어 개수에 대해서는 오름차순
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
					
					Word[] arr = new Word[len_w]; // 입력받은 워드들의 배열
					String[] answer = new String[len_in];
					
					// word string을 집어넣음
					for(int i=0 ; i<len_w ; i++)  arr[i]=new Word(words[i]); 
					
					for(int i=0 ; i<len_in ; i++) {
						Arrays.sort(arr);
						for(int j=0 ; j<len_w ; j++) {
							if(arr[j].word.charAt(0)==user_inputs[i].charAt(0)) { // 워드 앞글자와 입력받은 알파벳이 일치한다면
								answer[i]=arr[j].word;
								arr[j].count++; // count 늘려줌
								break;
							}
						}
					}
					return answer;
		}
		
	 public static void main(String[] args) throws Exception {
	     Scanner sc = new Scanner(System.in);
	     
	     // k, n 입력받기
	     k = sc.nextInt();
	     n = sc.nextInt();
	     sc.nextLine();
	     String[] words = new String[k];
	     String[] user_inputs = new String[n];
	     
	     // 미리 주어지는 단어 입력 받기
	     for(int i = 0; i < k; i++) words[i] = sc.nextLine();
	     for(int i = 0; i < n; i++) user_inputs[i] = sc.nextLine();
				
	     String[] answer = solution(words, user_inputs);
				
	     for(String ans : answer) System.out.println(ans);
	 }
}

