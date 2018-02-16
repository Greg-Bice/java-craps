import java.util.Scanner;

public class Init {
	
	public static Scanner input = new Scanner( System.in );
	
	private static String[] instructions = new String[] { 
			
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

	public static void main(String[] args) {
		
		for ( String v: instructions ) {
			System.out.println( v );
		}
		
		QueryStart( "Would you like to play?" );
				

	}
	
	public static void QueryStart( String query ) {
		
		System.out.println( String.format( "%s (Y/N)", query ) );
		
		String retort = input.nextLine().toLowerCase();
		
		while ( !retort.equals( "y" ) && !retort.equals( "n" ) ) {
			System.out.println( "Invalid response; please, try again!" );
			retort = input.nextLine().toLowerCase();
		}
		
		if ( retort.equals( "n" ) ) {
			
			System.out.println( "Okay, goodbye!" );
			System.exit(0);
			
		} else {
			
			new Round(); // Doesn't need to be assigned to a variable since it is played via the constructor
			
		}
		
	}

}
