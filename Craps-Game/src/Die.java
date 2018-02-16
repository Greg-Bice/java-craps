public class Die {

	private int DieValue;

	public Die() {
		
		// TODO: Determine DieVaue.. a random number between 1 and 6
		DieValue = (int) ( Math.random() * 6 ) + 1; // Casting to int allows the avoidance of using floor
		
	}

	public int getDieValue() {
		return DieValue; // returns the die's value.
	}
}
