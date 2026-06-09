class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for( int i = 0; i < arr1.length; i++ ){

            String firstBinaryValue = String.format( "%"+n+"s",Integer.toBinaryString( arr1[i] ) );
            String secondBinaryValue = String.format( "%"+n+"s",Integer.toBinaryString( arr2[i] ) );
            StringBuilder builder = new StringBuilder();

            for( int j = 0; j < firstBinaryValue.length(); j++ ){

                if( firstBinaryValue.charAt(j) == '1' || secondBinaryValue.charAt(j) == '1' ){

                    builder.append("#");
                }else{

                    builder.append(" ");
                }
            }

            answer[i] = builder.toString();
        }

        return answer;
    }
}