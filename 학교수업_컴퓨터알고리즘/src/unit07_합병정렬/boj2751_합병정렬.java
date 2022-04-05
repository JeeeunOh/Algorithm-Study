package unit07_합병정렬;
import java.util.Scanner;

public class boj2751_합병정렬 {
    public static void main(String[] args) {
 
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
 
    // 1~N 까지 사용
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
    else { // 아니면 또 나눠줌
 
        int midA = (int)arr.length/2;
        int midB = arr.length-midA;
 
        int arrA[] = new int[midA];
        int arrB[] = new int[midB];
 
        for(int i = 0 ; i<midA ; i++)  arrA[i] = arr[i]; 
        for(int i = 0 ; i<midB ; i++) arrB[i] = arr[i+midA];
 
        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);
 
        // 나눈 배열이 mergesort 를 타고 나오면 합쳐줌
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
 
    // A, B 배열 각 인덱스가 초과되지 않을 때 까지 비교해서 합침
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
 
    // 한쪽이 다 스캔됐으면 나머지 한쪽은 full로 갖다 붙임
    if(idxA<arrA.length) {
        System.arraycopy(arrA, idxA, mergeArr, idx, length-idx);
    }
    else if(idxB<arrB.length) {
        System.arraycopy(arrB, idxB, mergeArr, idx, length-idx);
    }
        return mergeArr;
    }
}