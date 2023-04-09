package camp_contest_초급;

import java.util.*;
import java.io.*;
/*자주 나오는 단어일수록 앞에 배치한다.
해당 단어의 길이가 길수록 앞에 배치한다.
알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
*/
public class A {
	/*현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
	현재 객체 == 파라미터로 넘어온 객체: 0 리턴
	현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
	음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
*/
	static class Word implements Comparable<Word> {
	    String string ;
	    int num;
	    public Word(String s, int n) {
	    	this.string=s;
	    	this.num=n;
	    }
	    @Override
	    public int compareTo(Word p) {
	        if(this.num > p.num) {
	            return -1; //  단어 개수에 대해서는 내림차순
	        } else if ( this.num < p.num) return 1;
	        else {
	        	if(this.string.length() > p.string.length())  return -1; // 단어 길이 대해 내림차순
	        	else if(this.string.length() < p.string.length()) return 1;
	        	else {
	        		return 1;
	        	}
	        }
	    }
	    public String toString() {
	    	return string; // 출력은 단어만
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 영어 지문에 나오는 단어의 개수
		int M = sc.nextInt(); // 외울 단어의 길이 기준
		
		Word[] word = new Word[N];
		Arrays.fill(word, new Word("0",1));
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0 ; i<N ; i++) { 
			String a = sc.next();
			if(a.length()<M) { // 스트링 길이가 M보다 작으면 넘김
				continue;
			} else { // - 보다 크고,
				if(map.containsKey(a)) { // 해당 단어 이미 존재하면
					int idx = map.get(a); // map에서 해당 스트링 존재하는 idx 가져와서
					Word w = word[idx];
					Word new_w = new Word(a, w.num+1); // 해당 단어 이미 존재하면 갯수 늘림
					word[idx] = new_w;// 이것을 같은 자리에 저장해줌
				} else { // 존재하지 않으면 맵에 넣음
					map.put(a, i); //Word[i]에 a에 대한 정보가 존재함
					word[i]=new Word(a,1);
				}
			}
		}
		Arrays.sort(word);
		for(int i=0 ; i<N ; i++) {
			if(word[i].string.equals("0")) continue;
			System.out.println(word[i]); // toString에 정의된 형식으로 출력
		}
	}
}
