import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class HogwartCup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		in.nextLine();
		for(int k = 0; k < testCases; k++){
			int amountOfStudents = in.nextInt();
			int amountOfRevisions = in.nextInt();
			int amountOfGroups = in.nextInt();
			in.nextLine();

			ArrayList<Integer> students = new ArrayList<Integer>();
			ArrayList<Integer> groups = new ArrayList<Integer>();

			for(int i=0; i < amountOfStudents; i++){
				int sScore = in.nextInt();
				students.add(sScore);
			}

			in.nextLine();
			while(amountOfGroups != 0 || amountOfRevisions != 0){
				String line[] = in.nextLine().split("\\s+");

				String c = line[0];
				int num1 = Integer.parseInt(line[1]);
				int num2 = Integer.parseInt(line[2]);

				if(c.equals("R")){
					//if(num1 > 0 && num1 <= students.size()){
						students.set(num1-1, students.get(num1-1)+num2);
					//}
					amountOfRevisions--;
				} else if(c.equals("G")){
					int score = 0;
					//if(num1 > 0 && num2 <= students.size()){
						for(int i = num1-1; i < num2; i++){
							score += students.get(i);
						}
						groups.add(score);
						amountOfGroups--;
					//}
				}
			}

			System.out.print(Collections.max(groups));
		}

	}

}
