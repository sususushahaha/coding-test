public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_num = {31,10, 45, 1, 6, 19};
        Solution3 sol = new Solution3();
        int arr[] = sol.solution(lottos, win_num);
        for(int i=0; i<2; i++){
            System.out.println(arr[i]);
        }

    }
}
class Solution3 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int best=0;
        int worst=0;

        for(int i=0; i<lottos.length; i++){
            for(int j =0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]) worst++;
            }
            if(lottos[i]==0) best++;
        }

        answer[0] = Math.min(7-(best+worst),6);
        answer[1] = Math.min(7-(worst),6);

        int input =best+worst;
        for(int i =0; i<2; i++){
            switch(input){
                case 6:
                    answer[i]=1;
                    break;
                case 5:
                    answer[i]=2;
                case 4:
                    answer[i]=3;
                    break;
                case 3:
                    answer[i]=4;
                    break;
                case 2:
                    answer[i]=5;
                    break;
                default :
                    answer[i]=6;
                    break;
            }
            input = worst;
        }

        return answer;
    }
}
