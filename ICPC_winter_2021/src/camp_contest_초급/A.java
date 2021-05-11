package camp_contest_�ʱ�;

import java.util.*;
import java.io.*;
/*���� ������ �ܾ��ϼ��� �տ� ��ġ�Ѵ�.
�ش� �ܾ��� ���̰� ����� �տ� ��ġ�Ѵ�.
���ĺ� ���� ������ �տ� �ִ� �ܾ��ϼ��� �տ� ��ġ�Ѵ�
*/
public class A {
	/*���� ��ü < �Ķ���ͷ� �Ѿ�� ��ü: ���� ����
	���� ��ü == �Ķ���ͷ� �Ѿ�� ��ü: 0 ����
	���� ��ü > �Ķ���ͷ� �Ѿ�� ��ü: ��� ����
	���� �Ǵ� 0�̸� ��ü�� �ڸ��� �״�� �����Ǹ�, ����� ��쿡�� �� ��ü�� �ڸ��� �ٲ��.
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
	            return -1; //  �ܾ� ������ ���ؼ��� ��������
	        } else if ( this.num < p.num) return 1;
	        else {
	        	if(this.string.length() > p.string.length())  return -1; // �ܾ� ���� ���� ��������
	        	else if(this.string.length() < p.string.length()) return 1;
	        	else {
	        		return 1;
	        	}
	        }
	    }
	    public String toString() {
	    	return string; // ����� �ܾ
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���� ������ ������ �ܾ��� ����
		int M = sc.nextInt(); // �ܿ� �ܾ��� ���� ����
		
		Word[] word = new Word[N];
		Arrays.fill(word, new Word("0",1));
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0 ; i<N ; i++) { 
			String a = sc.next();
			if(a.length()<M) { // ��Ʈ�� ���̰� M���� ������ �ѱ�
				continue;
			} else { // - ���� ũ��,
				if(map.containsKey(a)) { // �ش� �ܾ� �̹� �����ϸ�
					int idx = map.get(a); // map���� �ش� ��Ʈ�� �����ϴ� idx �����ͼ�
					Word w = word[idx];
					Word new_w = new Word(a, w.num+1); // �ش� �ܾ� �̹� �����ϸ� ���� �ø�
					word[idx] = new_w;// �̰��� ���� �ڸ��� ��������
				} else { // �������� ������ �ʿ� ����
					map.put(a, i); //Word[i]�� a�� ���� ������ ������
					word[i]=new Word(a,1);
				}
			}
		}
		Arrays.sort(word);
		for(int i=0 ; i<N ; i++) {
			if(word[i].string.equals("0")) continue;
			System.out.println(word[i]); // toString�� ���ǵ� �������� ���
		}
	}
}
