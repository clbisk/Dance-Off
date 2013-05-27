public class DownArrow extends Arrow {
	//variables
	/**private variable to store x-position of this Arrow*/
	private static int xPos;
	/**private variable to store y-position of this Arrow*/
	private static int yPos;
	
	/**constructor*/
	public DownArrow() {
		//starts downArrow image on the screen with a predetermined x and y-coordinate for down arrows
		//puts self into arrows[] of danceQueuePanel
	}
	
	//methods
	/**getter for private variable xPos*/
	public int getXPos() {
		return 0;
		//returns xPos
	}
	/**getter for private variable yPos*/
	public int getYPos() {
		return 0;
		//returns yPos
	}
	/**setter for private variable xPos*/
	public void setXPos(int x) {
		//sets xPos to x
		//xPos = x;
	}
	/**setter for private variable yPos*/
	public void setYPos(int y) {
		//sets yPos to y
		//yPos = y;
	}
	/**moves the arrow up the screen towards the timing bar*/
	public void move() {
		//moves arrow up at each tick of the timer
	}
}