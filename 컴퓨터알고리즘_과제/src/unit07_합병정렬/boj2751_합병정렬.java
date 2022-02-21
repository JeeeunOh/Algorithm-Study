package unit07_�պ�����;
import java.util.Scanner;

public class boj2751_�պ����� {
    public static void main(String[] args) {
 
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
 
    // 1~N ���� ���
    int[] arr = new int[N];
 
    int idx = 0;
    while (idx < N) {
        arr[idx] = sc.nextInt();
        idx++;
    }
 
    arr = mergeSort(arr);
 
    for(int i=0; i<N; i++) {
        System.out.println(arr[i]);
    }
}
 
static int[] mergeSort(int[] arr) {
    if(arr.length == 1)   return arr;
    else { // �ƴϸ� �� ������
 
        int midA = (int)arr.length/2;
        int midB = arr.length-midA;
 
        int arrA[] = new int[midA];
        int arrB[] = new int[midB];
 
        for(int i = 0 ; i<midA ; i++)  arrA[i] = arr[i]; 
        for(int i = 0 ; i<midB ; i++) arrB[i] = arr[i+midA];
 
        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);
 
        // ���� �迭�� mergesort �� Ÿ�� ������ ������
        for(int i = 0 ; i<arrA.length ; i++) arr[i]=arrA[i];
        for(int i = arrA.length; i<arrA.length+arrB.length ; i++) arr[i] = arrB[i-arrA.length];
        //arr = mergeOperator(arrA, arrB);
 
    }
 
    return arr;
}
 
private static int[] mergeOperator(int[] arrA, int[] arrB) {
    int length = arrA.length+arrB.length;
    int[] mergeArr = new int[length];
    int idx = 0;
    int idxA = 0;
    int idxB = 0;
 
    // A, B �迭 �� �ε����� �ʰ����� ���� �� ���� ���ؼ� ��ħ
    while(idxA<arrA.length&&idxB<arrB.length) {
        if(arrA[idxA]<arrB[idxB]) {
            mergeArr[idx] = arrA[idxA];
            idx++;
            idxA++;
        }
        else {
            mergeArr[idx] = arrB[idxB];
            idx++;
            idxB++;
        }
    }
 
    // ������ �� ��ĵ������ ������ ������ full�� ���� ����
    if(idxA<arrA.length) {
        System.arraycopy(arrA, idxA, mergeArr, idx, length-idx);
    }
    else if(idxB<arrB.length) {
        System.arraycopy(arrB, idxB, mergeArr, idx, length-idx);
    }
        return mergeArr;
    }
}