import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class NewId {
    public static void main(String[] args) {
        New_ID id = new New_ID();
        System.out.print(id.solution("z-"));

    }
}

class New_ID{
    public String solution(String new_id){
        String answer = "";

        //1단계 대문자-> 소문자
        String str = new_id.toLowerCase();

        //2단계 소문자, 숫자, -, _, .
        str = str.replaceAll("[^a-z0-9-_.]", "");

        //3단계 .두번 연속시 하나로
        str = str.replaceAll("\\.{2,}", ".");


        //4단계 처음과 끝 .제거
        str = str.replaceAll("^[.]|[.]$", "");


       //5단계 빈문자열이면 a를 넣는다
        if(str.length()==0){
            str = "a";
        }

        //6단계 16자 이상이면 첫15 제외하고 삭제 마지막이 .이면 삭제
        if(str.length()>=16){
            System.out.println("gg");
            str = str.substring(0,15);
            while(str.endsWith(".")){
                str = str.substring(0,str.length()-1);
            }
        }
        //7단계 길이가2자 이하면, 마지막 문자를 길이가 3자가 될떄까지 반복
        if(str.length()<=2){
            while(str.length()<3){
                System.out.println(str.length());
                str = str + str.substring(str.length()-1);
            }
        }

        answer=str;
        return answer;
    }
}
