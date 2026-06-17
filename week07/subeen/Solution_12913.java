class Solution_12913 {
    int solution(int[][] land) {
        
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        int last = land.length - 1;

        return Math.max(Math.max(land[last][0], land[last][1]),
                        Math.max(land[last][2], land[last][3]));
    }

    public static void main(String[] args) {
        Solution_12913 s = new Solution_12913();
        System.out.println(s.solution(new int[][] {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}));
    }
}