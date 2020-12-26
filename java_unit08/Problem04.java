import java.io.*;
import java.util.*;

public class Problem04 {
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("src\\test.txt");  
			int c;
			Scanner sc = new Scanner(System.in);
			while ((c = in.read()) != -1 ) { // 한 문자씩 파일 끝까지 읽는다.
				System.out.print((char)c);
				//줄띄움 만나면
				if((char)c==('\n')) {
					try {
						Thread.sleep(1000000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				//q입력받으면
				if (sc.next().charAt(0)=='q')
					break;
			}
			in.close();
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}

	}

}
