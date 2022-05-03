package classwork16;

public class Bomb {

	private int currentPositionX;
	private int currentPositionY;
	
	public Bomb(int currentPositionX, int currentPositionY) {
		super();
		this.currentPositionX = currentPositionX;
		this.currentPositionY = currentPositionY;
	}
	public int getCurrentPositionX() {
		return currentPositionX;
	}
	public void setCurrentPositionX(int currentPositionX) {
		this.currentPositionX = currentPositionX;
	}
	public int getCurrentPositionY() {
		return currentPositionY;
	}
	public void setCurrentPositionY(int currentPositionY) {
		this.currentPositionY = currentPositionY;
	}
}
