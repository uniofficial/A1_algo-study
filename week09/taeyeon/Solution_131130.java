import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();

    public int solution(int[] cards) {
        int answer = 0;

        for(int i = 0 ; i < cards.length ; i++){
            if(cards[i] != 0){
                dfs(cards, i, cards[i], 1);
            }
        }

        if(result.size() > 1){
            Collections.sort(result, (o1,o2) -> o2 - o1);
            return result.get(0) * result.get(1);
        }else{
            return 0;
        }
    }

    private void dfs(int[] cards, int before, int idx, int cnt){
        idx--;
        cards[before] = 0;

        if(cards[idx] == 0){
            result.add(cnt);
        }else{
            dfs(cards, idx, cards[idx], cnt+1);
        }
    }
}