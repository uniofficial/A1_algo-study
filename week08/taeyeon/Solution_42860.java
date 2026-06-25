public class Solution {
    public int solution(String name) {
        int sum = 0;
        int cnt = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            sum += calc(name.charAt(i));
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            if (next - i > 1) {
                cnt = Math.min(cnt, Math.min(i * 2 + name.length() - next, (name.length() - next) * 2 + i));
            }
        }

        return sum + cnt;
    }

    public int calc(char target) {
        return Math.min(target - 'A', 'Z' - target + 1);
    }
}