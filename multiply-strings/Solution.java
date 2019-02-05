class Solution {
	public int getSingleDigitCarry(int num) {
		return (num - num % 10) / 10;
	}
	public int getSingleDigitRemainder(int num) {
		return num % 10;
	}

	public String multiply(String num1, String num2) {
		char[] revNum1 = num1.toCharArray();
		char[] revNum2 = num2.toCharArray();
	       	int minLength = Math.min(revNum1.length, revNum2.length);
		String result = "";
		int currSum = 0;
		int carry = 0;
		for (int k = 1; k<minLength; k++) {
			int currNum1 = Integer.parseInt(String.valueOf(revNum1[k]));
			int currNum2 = Integer.parseInt(String.valueOf(revNum2[k]));
			int currMul = currNum1 * currNum2;
			currSum += getSingleDigitRemainder(currMul);
			carry = getSingleDigitCarry(currMul) + getSingleDigitCarry(currSum);
			currSum = getSingleDigitRemainder(currSum);
			result = "" + currSum + result;
		}		
		
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		Solution s =  new Solution();
		s.multiply("123", "456");
	}
}
