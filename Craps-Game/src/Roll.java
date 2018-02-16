public class Roll {

	private Die d1, d2; // Condensed to single line since of same dataType
	private int Score; // Will be the sum of the two die

	public Roll() {
		// TODO: Create an instance of d1 and d2...
		// TODO: Determine 'Score'
		
		d1 = new Die(); // Create an instance of the Die class
		d2 = new Die(); // Ditto
		
		Score = d1.getDieValue() + d2.getDieValue(); // Sums the die to get the dice value;
		
	}

	public int getScore() {
		return Score; // Returns the private int of Score which was set in the constructor.
	}

}
