import java.util.HashMap;
import java.util.LinkedList;

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};
        Open_Chat op = new Open_Chat();

        String[] result = op.solution(record);
        for(String x : result){
         System.out.println(x);
        }

    }
}

class Open_Chat {
    public String[] solution(String[] record) {
        String[] answer = {};
        int no_dialog =0;

        HashMap<String, String> name_Info = new HashMap<>();

        for(int i=0; i<record.length; i++){//어차피 변경한게 마지막이므로
            String[] chat_Info = record[i].split(" ");
            if(chat_Info[0].equals("Change")) no_dialog++;
            if(chat_Info[0].equals("Leave")) continue;

            name_Info.put(chat_Info[1],chat_Info[2]);

        }
        answer = new String[record.length-no_dialog];

        StringBuilder sb = new StringBuilder();
        int k =-1;

        for(int i=0; i<record.length; i++){
            String[] chat_Info = record[i].split(" ");
            sb.append(name_Info.get(chat_Info[1]));

            if(chat_Info[0].equals("Enter")){
                sb.append("님이 들어왔습니다.");
                k++;
            }
            else if(chat_Info[0].equals("Leave")){
                sb.append("님이 나갔습니다.");
                k++;
            }
            else if(chat_Info[0].equals("Change")){
                sb.setLength(0);
                continue;
            }

            answer[k] = sb.toString();
            sb.setLength(0); //초기화
        }

        return answer;
    }
}