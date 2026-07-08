
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_92341 {
    Map<String, String> inCar;
    Map<String, Integer> totalTime;

    public int[] solution(int[] fees, String[] records) {

        inCar = new HashMap<>();
        totalTime= new HashMap<>();

        for(String record : records){
            String[] arr = record.split(" ");

            String time = arr[0];
            String number = arr[1];
            String type = arr[2];

            if(type.equals("IN"))
                inCar.put(number, time);

            else if(type.equals("OUT")){
                String start = inCar.get(number);
                int diff = getTime(start, time);
                totalTime.put(number, totalTime.getOrDefault(number, 0) + diff);
                inCar.remove(number);
            }
        }

        // 출차 기록이 없는 차 정리 
        for (String num : inCar.keySet()) {
            String start = inCar.get(num);
            int diff = getTime(start, "23:59");
            totalTime.put(num, totalTime.getOrDefault(num, 0) + diff);
        }

        List<String> cars = new ArrayList<>(totalTime.keySet());

        // 차량 번호 오름차순 정렬 
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for(int i = 0; i < answer.length; i++){
            int minutes = totalTime.get(cars.get(i));
            answer[i] = calculate(fees, minutes);
        }

        return answer;
    }

    private int getTime(String start, String end){
        String[] s = start.split(":");
        String[] e = end.split(":");

        int startTime = Integer.parseInt(s[0])* 60 + Integer.parseInt(s[1]);
        int endTime = Integer.parseInt(e[0])* 60 + Integer.parseInt(e[1]);

        return endTime - startTime;
    }

    private int calculate(int[] fees, int minutes){
        if(minutes <= fees[0])
            return fees[1];

        else {
            int diff = minutes - fees[0];
            return fees[1] + ((diff + fees[2] - 1) / fees[2] ) * fees[3];
        }
    }

    public static void main(String[] args){
        Solution_92341 s = new Solution_92341();
        System.out.println(Arrays.toString(s.solution(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(s.solution(new int[] {120, 0, 60, 591}, new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
        System.out.println(Arrays.toString(s.solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"})));
    }
}