import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;


public class LongestCableWay {

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		int numout = 0;
		int trashin = 0;
		int numin = 0;
		int lenght;
		Stack<Integer> joints = new Stack<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> trash = new Stack<Integer>();
		ArrayList<Integer> inventory = new ArrayList<Integer>();
		ArrayList<Integer> solutions = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);

		lenght = in.nextInt();
		while(0==0){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if(num1 == 0 && num2 == 0)
				break;
			for(int i = 0; i < num2; i++){
				inventory.add(num1);
			}
		}

		Collections.sort(inventory);
		insertIntoStack(stack, inventory);

		
		while(!stack.isEmpty()){
			if(stack.peek() > lenght)
				trash.push(stack.pop());
			else {
				joints.push(stack.pop());
				lenght -= joints.peek();
				numin++;
			}

			if(lenght == 0) {
				solutions.add(joints.size() - 1);
				break;
			}
		}

		if(!solutions.isEmpty())
			System.out.print(Collections.min(solutions));
		else
			System.out.print("No solution possible");
	}


	private static void insertIntoStack(Stack<Integer> stack, ArrayList<Integer> inventory) {
		for(int i = 0; i < inventory.size(); i++){
			stack.push(inventory.get(i));
		}
	}

}
