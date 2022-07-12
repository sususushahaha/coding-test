/*
 * 0~9숫자와 +,-가 있다.
 * +는 +1 -는 -1이다. 0에서 -는 변하지 않음
 * 이동하려는 채널 N으로 이동하기
 * 어떤 버튼이 고장났는지 주어졌을 때,
 * 채널 n을 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지
 * 현재 100번
* */

import java.util.Scanner;

public class remo1107 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int target = sc.nextInt();
         int m = sc.nextInt();

         boolean[] brocken = new boolean[10];
         for(int i=0; i<m; i++){
             int n = sc.nextInt();
             brocken[n] = true;
         }

         int result = Math.abs(target - 100);
         for(int i =0; i<=999999; i++){
             String str = String.valueOf(i);
             int len = str.length();

             boolean isBreak = false;
             for(int j =0; j<len; j++){
                 if(brocken[str.charAt(j) - '0']){ //고장난 버튼 누른다면
                     isBreak=true;
                     break; //더이상 탐색x
                 }
             }
             if(!isBreak){//고장난 버튼을 안누른다면
                 int min = Math.abs(target - i) + len;//i를 누른후(len) target까지 이동하는 횟수(target-i)
                 result = Math.min(min, result);
             }
         }
         System.out.println(result);
     }
}
