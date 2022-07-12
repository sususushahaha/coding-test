import java.util.Scanner;

public class ContinueWrite1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;
        int plus = 1;
        int num = 10;


        for(int i =1; i<=input; i++){
            if(i%num==0){
                plus++;
                num*=10;
            }
            count+=plus;
        }

        System.out.println(count);
    }
}
