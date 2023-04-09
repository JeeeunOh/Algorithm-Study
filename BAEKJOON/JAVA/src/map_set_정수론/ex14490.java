package map_set_Á¤¼ö·Ð;

import java.io.*;
import java.util.*;

class ex14490 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine();
    	String num1="",num2="";
    	int n1=0,n2=0;
    	for(int i=0; i<input.length(); i++) {
    		if(input.charAt(i)== ':') {
    			for(int j=0; j<i; j++)  num1 +=input.charAt(j); 
    			for(int k=i+1; k<input.length(); k++)  num2 +=input.charAt(k);
    			break;
    		}
    	}//insert
    	 n1 = Integer.parseInt(num1);
    	 n2 = Integer.parseInt(num2);
    	int min = Math.min(n1, n2);
    	
    	while(true) {
    		if(n1 % min ==0 && n2 % min ==0) {
    			n1/=min;
    			n2/=min;
    		} else  min--; 
    		if(min==1) {
    			System.out.println(n1+":"+n2);
    			break;
    		}
    	}
	}
}