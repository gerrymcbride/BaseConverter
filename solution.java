
public class Solution {
	
	public static void main(String [] args){
		
		stack myStack = new stack(15);
		
		System.out.println(baseTenConvert(5,myStack, 43));
		
	}
	
	public static long baseTenConvert(long currentBase, stack number, long baseNumber){
		
		int PowerCount = 0;
		int count = number.top;
		long temp;
		long result = 0;
		
		splitNumber(baseNumber, number);
		
		while(count >= 0){
			temp = Math.round(Math.pow(currentBase, PowerCount) * number.peekSpecific(PowerCount));
			result = result + temp;
			count--;
			PowerCount++;
			
			
			
		}
		
		return result;
	}
	// splits numbers by digit eg. 1234 returns in stack [1,2,3,4]
	public static stack splitNumber(long q, stack arrayOfNum){
		
		int count = String.valueOf(q).length(); // count works off length, formula for N runs equivelant to N.length
		long x = q; // q as x
		long y = 0; // y to store the processed x
		boolean stop = false; // bool to continuosly execute below
		
		while(!stop){
			// if length of N is 0, y = what is left of x
			if(count == 0){
				y = x;
				
			// runs if x is greater than ten and doesn't MOD to 0	
			} else if(x % 10 != 0 && x > 10) {
				y = x % 10;
				x = x - y;
			// other cases result in 2 digit // CHECK TEST CASES LARGER THAN 10
			} else {
				y = x / 10;
				
			}
			
			arrayOfNum.push(y);
			count--;
			
			if(count==0){
				stop = true;
			}
			
		}
		
		return arrayOfNum;
		
	}
}
// stack class
class stack {
	
	private int max; // maxsize of stack
	private static long[] stackArray; //create stack with long types
	static int top; // monitors top of stack
	
	public stack(int s){ // constructor 
		
		max = s;
		stackArray = new long[max];
		top = -1;
	}
	
	// push method of stack
	public static void push(long i){
		top++;
		stackArray[top] = i;
		
	}
	// view specific element of stack
	public static long peekSpecific(int x){
		return stackArray[x];
		
	}
	// view top element in traditional stackish style
	public static long peek(){
		return stackArray[top];
		
	}
}	
