import java.util.ArrayList;
import java.util.Scanner;


public class Trackingbilliarballs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int scenarios = in.nextInt();
		for(int scnes = 0; scnes < scenarios; scnes++){
			ArrayList<Ball> balls = new ArrayList<Ball>();
			int time;
			int target;
			int amountOfBalls = in.nextInt();
			for(int i=0; i < amountOfBalls; i++){
				int pos = in.nextInt();
				int vel = in.nextInt();
				if(pos <= 0 || pos >= 100 )
					balls.add(new Ball(-1, vel));
				else
					balls.add(new Ball(pos, vel));
			}
			target = in.nextInt();
			time = in.nextInt();

			while(time != 0){
				for(int i=0; i < balls.size(); i++){
					Ball b1 = balls.get(i);
					for(int j=i+1; j<balls.size(); j++){
						Ball b2 = balls.get(j);
						if(b1.getY() == b2.getY() && b1.getVel() == b2.getVel()){
							balls.get(i).invertVel();
							balls.get(j).invertVel();
						} else if(b1.getY() == b2.getY() && b1.getVel() != b2.getVel()){
							int tempV = b1.getVel();
							b1.setVel(b2.getVel());
							b2.setVel(tempV);

						} 
						if((b1.getVel() > 0 && b2.getVel() > 0) || (b1.getVel() < 0 && b2.getVel() < 0)){
							int Ydif = Math.abs(b1.getY()-b2.getY());
							int Vdif = Math.abs(b1.getVel() - b1.getVel());
							if(Vdif >= Ydif){
								if(Math.abs(b1.getVel()) > Math.abs(b2.getVel())){
									if((b1.getVel() > 0 && b1.getY() < b2.getY()) || (b1.getVel() < 0 && b1.getY() > b2.getY())){
										int tempV = b1.getVel();
										b1.setVel(b2.getVel());
										b2.setVel(tempV);
										if(b1.getVel() > 0)
											balls.get(i).move((Vdif-Ydif));
										else
											balls.get(i).move(-(Vdif-Ydif));
										if(b2.getVel() > 0)
											balls.get(j).move((Vdif-Ydif));
										else
											balls.get(j).move(-(Vdif-Ydif));
									}
								}
							}

						} else {
							int Ydif = Math.abs(b1.getY()-b2.getY());
							int Vadd = Math.abs(b1.getVel()) + Math.abs(b2.getVel());
							if(Vadd >= Ydif){
								if(b1.getVel() > b2.getVel() && b2.getY() > b1.getY()){
									int tempV = b1.getVel();
									b1.setVel(b2.getVel());
									b2.setVel(tempV);
									if(b1.getVel() > 0)
										balls.get(i).move(-(Vadd-Ydif));
									else
										balls.get(i).move((Vadd-Ydif));
									if(b2.getVel() > 0)
										balls.get(j).move(-(Vadd-Ydif));
									else
										balls.get(j).move((Vadd-Ydif));
								}
							}

						}
					}
					balls.get(i).move();
				}

				time--;
			}

			Ball b = balls.get(target-1);
			if(b.getY() > 100){
				System.out.println("100");
			} else if(b.getY() < 0){
				System.out.println("0");
			} else {
				System.out.println(b.getY());
			}
		}

	}
}

class Ball{
	int y;
	int vel;

	public Ball(int y, int vel) {
		super();
		this.y = y;
		this.vel = vel;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVel() {
		return vel;
	}

	public void move(){
		y += vel;
	}

	public void move(int i){
		y += i;
	}

	public void invertVel(){
		vel *= -1;
	}
	public void setVel(int vel) {
		this.vel = vel;
	}
}
