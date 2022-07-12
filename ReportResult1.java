import java.util.*;
public class ReportResult1 {
    public static void main(String[] args) {
        new Solution();
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reporteIdx = new HashMap<>();

        //초기화
        for(int i =0; i < id_list.length; i++){
            reporterInfoMap.put(id_list[i], new HashSet<>());
            reporteIdx.put(id_list[i], i);
        }

        //신고한 ID 신고된 ID(set)으로 저장
        for(String s: report){
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            reporterInfoMap.get(to).add(from);

        }

        for(int i =0; i<id_list.length; i++){
            HashSet<String> send = reporterInfoMap.get(id_list[i]);
            if(send.size() >= k){
                for(String name : send){
                    answer[reporteIdx.get(name)]++;
                }
            }
        }
        return answer;
    }
}