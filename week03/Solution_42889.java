class Solution {
    public int[] solution(int N, int[] stages) {
        int user = stages.length;
        int[] cnt = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {
            cnt[stages[i]]++;
        }

        double[] falseRate = new double[N + 1];

        for (int i = 1; i < falseRate.length; i++) {
            if (user == 0) {
                falseRate[i] = 0;
            } else {
                falseRate[i] = (double) cnt[i] / user;
            }

            user = user - cnt[i];
        }

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (falseRate[answer[j]] < falseRate[answer[j + 1]]) {
                    int temp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = temp;
                }
            }
        }

        return answer;
    }
}