public class Compression {
    public static void main(String[] args) {

        Compresstion_  a = new Compresstion_ ();
        System.out.println (a.solution("aabbaccc"));


    }
}

class Compresstion_ {
    public int solution(String s) {
        int answer = s.length();
        int num_length = 0;


        for(int cut_length = 1; cut_length<=s.length()/2; cut_length++){
            int count = 1;
            String str = s.substring(0, cut_length);

            for(int j =cut_length; j<=s.length(); j+=cut_length) {
                String next = s.substring(j, j + cut_length > s.length() ? s.length() : cut_length + j);

                if (str.equals(next)) count++;
                else {
                    num_length += count != 1 ? cut_length + 1 : cut_length;
                    str = next;      // 다음 문자를 압축할 문자로 지정
                    count = 1;       // 압축 정도 1로 초기화
                }
            }
                num_length +=str.length(); //나머지
            System.out.println(num_length);
                answer = Math.min(answer,num_length);
                num_length =0;
            }
            return answer;
    }
}


class Solution4 {
    public int solution(String s) {
        int answer = s.length();    // 압축하기 전 문자열 길이로 초기화

        for(int i = 1; i <= s.length() / 2; i++){
            int zipLevel = 1;                           // 현재 압축정도
            String zipStr = s.substring(0, i);          // 압축할 문자
            StringBuilder result = new StringBuilder(); // 압축완료한 문자를 저장할 StringBuilder

            for(int j = i; j <= s.length(); j += i){
                // 다음 문자 추출
                String next = s.substring(j, j + i > s.length() ? s.length() : i + j);
                // 다음 문자와 현재 문자가 같으면 zipLevel증가
                if(zipStr.equals(next)) zipLevel++;
                    // 다음 문자와 현재 문자가 다를 경우
                else{
                    // (압축이 안됬을 경우는 공백, 압축이 됬을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,
                    result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = next;      // 다음 문자를 압축할 문자로 지정
                    zipLevel = 1;       // 압축 정도 1로 초기화
                }
            }
            result.append(zipStr);      // 마지막에 추가안된 zipStr추가
            System.out.println(result);
            answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장
        }

        return answer;
    }
}
