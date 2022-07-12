import java.util.ArrayList;

public class EnglishWord {
    public static void main(String[] args) {
        change c = new change();
        System.out.println( c.solution("one4seveneight"));

    }
}
class change {
    public int solution(String s) {
        int answer = 0;
        String[] num_word = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


        for(int i =0; i<10; i++){
           s= s.replaceAll(num_word[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);


        return answer;
    }
}