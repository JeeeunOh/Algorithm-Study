package 스택_큐_덱;
/*
 * Stack<Integer>로 문자열에서 " ( "를 만나면  인덱스를 스택에 넣는다.
*(그리고 " ) " 를 만나면 스택의 top( peek() )에 있는 변수가 지금 인덱스의 -1번째 인지 확인하고 레이저로 취급한다. 
 * 레이저를 만났을 때 pop() 을 한번 하고 스택의 사이즈를 정답에 더해줌
 */
import java.util.*;

public class ex10799 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.substring(i,i+1).equals("(")) stack.push(i);
            else {
                if(stack.peek() == i-1) {
                    stack.pop();
                    count+=stack.size();
                }
                else {
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}