import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PassingtheNumberBall {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		 int numberOfStudents;
		 ArrayList<Coor> coorList = new ArrayList<Coor>();
		 ArrayList<Coor> list = new ArrayList<Coor>();
		 Coor grid[][];
		
		numberOfStudents = in.nextInt();
		while(0==0){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if(num1 == -999 && num2 == -999)
				break;
			else {
				coorList.add(new Coor(num1, num2));
			}
		}
		
		int i = 0;
//		while (i*i < numberOfStudents){
//			i++;
//		}
		
		ArrayList<Integer> pList = getPrimeList(numberOfStudents);

		//Coor[y][x]
		grid = new Coor[101][101];
		int x = 50;
		int y = 50;
		int a = 0;
		int b = 0;
		int j = 1;
		int h = 1;
		i = 0;
		
		outsideloops:
		while(numberOfStudents > 0){
			for(int k = 0; k < j; k++){
				Coor c = new Coor(b=b+h,a, pList.get(i++));
				grid[y][x=x+h] = c;
				list.add(c);
				numberOfStudents--;
				if(numberOfStudents==0)
					break outsideloops;
			}
			for(int k = 0; k < j; k++){
				Coor c = new Coor(b,a=a+h, pList.get(i++));
				grid[y=y-h][x] = c;
				list.add(c);
				numberOfStudents--;
				if(numberOfStudents==0)
					break outsideloops;
			}
			h *= -1;
			j++;
		}
		
		
		int p1 = getFirstCoor('1',list);
		int p3 = getFirstCoor('3',list);
		int p7 = getFirstCoor('7',list);
		int p9 = getFirstCoor('9',list);
		
		while(0==0){
			p1 = setStuff(p1,list,'1');
			p3 = setStuff(p3,list,'3');
			p7 = setStuff(p7,list,'7');
			p9 = setStuff(p9,list,'9');
			
		 if(p1 == 0 && p3 == 0 && p7 == 0 && p9 == 0)
			break;
		}
		
		for(int l = 0; l < coorList.size(); l++){
			Coor coorLooking = coorList.get(l);
			int o = 0;
				for(o = 0; o < list.size(); o++){
					Coor coorComparing = list.get(o);
					if(coorLooking.equals(coorComparing)){
						System.out.println("I should write " + coorComparing.getpNumber());
						if(coorComparing.getToCatch() == null)
							System.out.println("I should catch from nobody");
						else
							System.out.println("I should catch from " + coorComparing.getToCatch().getX() + " " + coorComparing.getToCatch().getY());
						System.out.println("I should throw to " + coorComparing.getToThrow().getX() + " " +  coorComparing.getToThrow().getY());
						break;
					}
				}
				if(o == list.size())
					System.out.println("No student at this location");
		}

	}

	private static int setStuff(int p, ArrayList<Coor> list, char c) {
		if(p == 0) return 0;
		for(int i = p-1; i >= 0; i--){
			Coor coor = list.get(i);
			String pNumber = ""+coor.getpNumber();
			if(pNumber.charAt(pNumber.length()-1)==c){
				list.get(p).setToThrow(coor);
				list.get(i).setToCatch(list.get(p));
				return i;
			}
		}
		list.get(p).setToThrow(new Coor(0,0));
		return 0;
	}

	private static int getFirstCoor(char c, ArrayList<Coor> list) {
		for(int i = list.size()-1; i >= 0; i--){
			Coor coor = list.get(i);
			String pNumber = ""+coor.getpNumber();
			if(pNumber.charAt(pNumber.length()-1)==c){
				return i;
			}
		}
		
		return -1;
	}
	
	private static ArrayList<Integer> getPrimeList(int i) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = 7;
		while(list.size() < i){
			if(primeNumCheck(num)){
				list.add(num++);
			}else{
				num++;
			}

		}

		return list;
	}

	private static boolean primeNumCheck(int num) {
		for(int i = (int) Math.sqrt(num) + 1; i > 1; i--){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

}

class Coor{
	int x;
	int y;
	int pNumber;
	Coor toThrow;
	Coor toCatch;
	
	public Coor(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Coor(int x, int y, int pNumber){
		this.x = x;
		this.y = y;
		this.pNumber = pNumber;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getpNumber() {
		return pNumber;
	}

	public Coor getToThrow() {
		return toThrow;
	}

	public void setToThrow(Coor toThrow) {
		this.toThrow = toThrow;
	}

	public Coor getToCatch() {
		return toCatch;
	}

	public void setToCatch(Coor toCatch) {
		this.toCatch = toCatch;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	@Override
	public boolean equals(Object obj) {
		Coor c = (Coor) obj;
		return (this.x == c.getX() && this.y == c.getY());
	}
	
}
