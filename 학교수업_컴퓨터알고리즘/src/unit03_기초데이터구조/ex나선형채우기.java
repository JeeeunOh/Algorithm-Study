package unit03_���ʵ����ͱ���;

import java.util.*;

public class ex������ä��� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[][] box = new int[a+1][a+1];

        //direction �� 1�� �� �����̵� / 0�϶��� ���� �̵�
        int right_direction = 1;
        int bottom_direction = 0;

        int right = 0;
        int bottom = 1;

        for(int i = 1 ; i <= a*a ; i++) {
            if(right_direction == 1 && bottom_direction == 0) {
                if(right+right_direction > a || box[right+right_direction][bottom] != 0) {
                    right_direction = 0; bottom_direction = 1;
                }
            }else if(right_direction == 0 && bottom_direction == 1) {
                if(bottom+bottom_direction > a || box[right+right_direction][bottom+bottom_direction] != 0) {
                    right_direction = -1; bottom_direction = 0;
                }
            }else if(right_direction == -1 && bottom_direction == 0) {
                if(right+right_direction < 1 || box[right+right_direction][bottom+bottom_direction] != 0) {
                    right_direction = 0; bottom_direction = -1;
                }
            }else if(right_direction == 0 && bottom_direction == -1) {
                if(bottom+bottom_direction < 1 || box[right+right_direction][bottom+bottom_direction] != 0) {
                    right_direction = 1; bottom_direction = 0;
                }
            }

            right = right+right_direction;
            bottom = bottom+bottom_direction;

            box[right][bottom] = i;

        }

        for(int i = 1 ; i<= a ; i++) {
            for(int j = 1 ; j <= a; j++) {
                System.out.print(box[j][i]+" ");
            }
            System.out.println("");
        }
    }
}