import java.util.Scanner;

public class Init {
	
	public static Scanner input = new Scanner( System.in ); // Initializing scanner for user input on extra questions at start of game
	
	private static String[] instructions = new String[] { // Array of instructions for game; not very detailed.
			
			"Welcome to Craps!",
			"The game revolves around you, the shooter.",
			"The shooter rolls the initial roll; The sum of the dice will make one of the following results:",
			"\tCRAPS: 2, 3, 12",
			"\tNATUALS: 7, 11",
			"\tPOINTS: 4, 5, 6, 8, 9, 10",
			"Rolling an initial CRAPS or NATURALS will end your round.",
			"Rolling an initial POINTS will begin the game; the goal is to roll this number again without rolling a 7.",
			"If successful, you score a point and win the round.",
			"Upon rolling a 7, you lose the round in an event known as a SEVEN-OUT.\n"
			
			};

	public static void main(String[] args) { // init.lua equivalent
		
		for ( String v: instructions ) { // For each element String in the array instructions do blah
			System.out.println( v ); // Print off the instructions one-by-one
		}
		
		QueryStart( "Would you like to play?" ); // Yes / No response accepted
				

	}
	
	public static void QueryStart( String query ) { // Made a main method so it could be called from the Round Class for recursive purposes
		
		System.out.println( String.format( "%s (Y/N)", query ) ); // Asks the query parameter with the added Y/N added on.
		
		String retort = input.nextLine().toLowerCase(); // Gets the user's response and makes it lowercase for easier comparison.
		
		while ( !retort.equals( "y" ) && !retort.equals( "n" ) ) { // Only care about responses 'y' and 'n'
			System.out.println( "Invalid response; please, try again!" ); // Same as above
			retort = input.nextLine().toLowerCase(); // Tries again to check if retort is 'y' or 'n'
		}
		
		if ( retort.equals( "n" ) ) {
			
			System.out.println( "Okay, goodbye!" );
			System.exit(0); // Exits the program; not sure the significance of the 0 but it makes it work. Exit code perhaps?
			
		} else {
			
			new Round(); // Doesn't need to be assigned to a variable since it is played via the constructor
			
		}
		
	}

}
