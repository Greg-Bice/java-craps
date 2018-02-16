public class Die {

	private int DieValue;

	public Die() {
		
		// TODO: Determine DieVaue.. a random number between 1 and 6
		DieValue = (int) ( Math.random() * 6 ) + 1;
		
	}

	public int getDieValue() {
		return DieValue;
	}
}
