class Solution_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String sk : skill_trees){
            String s = sk.replaceAll("[^" + skill + "]", "");

            if(skill.startsWith(s))
                answer++;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution_49993 s = new Solution_49993();
        System.out.println(s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }
}