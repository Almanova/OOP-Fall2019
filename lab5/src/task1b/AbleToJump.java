package task1b;

public interface AbleToJump extends Moveable {
	int lowFrequency = 5;
	int highFrequency = 20;
	
	void moveRight(int frequency);
	
	void moveLeft(int frequency);
	
	void moveUp(int frequency);
	
	void moveDown(int frequency);
}
