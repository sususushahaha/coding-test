import java.util.ArrayList;
import java.util.Scanner;

/*
 * push x: 정수 x를 스택에 넣는 연산
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다
 */
public class Stack10828 {
    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int ptr = 0;

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    stack.add(sc.nextInt());
                    ptr++;
                    break;
                case "pop":
                    if (ptr==0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack.get(--ptr)).append('\n');
                    stack.remove(ptr);
                    break;
                case "size":
                    sb.append(ptr).append('\n');
                    break;
                case "empty":
                    if (ptr == 0) {
                        sb.append(1).append('\n');
                    } else  sb.append(0).append('\n');
                    break;
                case "top":
                    if (ptr == 0) {
                        sb.append(-1).append('\n');
                    } else  sb.append(stack.get(ptr - 1)).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
