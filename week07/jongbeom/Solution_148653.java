package com.algo;

public class Solution_148653 {
	class Solution {
	    public int solution(int storey) {
	    	int answer = 0;
	    	
	    	while(storey >0) {
	    		
	    	int digit = storey%10;
	    	int nextDigit = (storey/10)%10;
	    	
	    	if(digit >= 0 && digit <=4) {
	    			answer += digit;
	    		
	    	}else if(digit >=6 && digit <= 9) {
	    			answer += (10-digit);
	    			storey+= 10;
	    			
	    	}else if(digit == 5) {
	    		if(nextDigit >= 0 && nextDigit <= 4) {
	    			answer += 5;
	    		}else if(nextDigit >=5 && nextDigit <= 9){
	    			answer += 5;
	    			storey+= 10;
	    		}
	    	}
	    	
	    	storey /= 10;
	        
	        
	    	}
	    	return answer;
	    }
	}
}
