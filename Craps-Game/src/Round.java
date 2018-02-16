import java.util.Arrays;
import java.util.LinkedList;

public class Round {

	private eGameResult gameResult; // Prepares the eGameResult Enumeration
	
	private LinkedList<Roll> rolls = new LinkedList<Roll>(); // Contains the list of all the rolls
	
	// I'm not sure if there is another way to define a LinkedList Literal but this seems to work for now.
	private LinkedList<Integer> craps = new LinkedList<Integer>( Arrays.asList( 2, 3, 12 ) );
	private LinkedList<Integer> naturals = new LinkedList<Integer>( Arrays.asList( 7, 11 ) );
	private LinkedList<Integer> points = new LinkedList<Integer>( Arrays.asList( 4, 5, 6, 8, 9, 10 ) );
	
	private boolean continueRound = true; // used for Looping game rolls
	
	
	public Round() {
		
		while ( continueRound ) { // Check to see if the loop should continue
		
			Roll initialRoll = new Roll(); // New instance of the roll.
			rolls.add( initialRoll ); // Adds the newest roll to the rolls Linklist
		
			boolean isFirstRound = ( rolls.size() == 1 ); // First round has special interactions so checks for that first.
			
			gameResult = shotResult( initialRoll.getScore(), isFirstRound ); // Passes the isFirstRound channel
			
			if ( isFirstRound ) { // The initial round has a special case for the CRAPS and NATURALS enums
			
				switch( gameResult ) { // Switch statement #1 of the game results;
				
					case CRAPS: case NATURAL: // Need to roll a POINT to continue past the first round
							
						System.out.println( String.format( "[ROUND OVER] Your initial roll was a [%d]! %s!", initialRoll.getScore(), gameResult ) ); // Lose
						continueRound = false; // Round is over and loop should not 
							
						break; // Terminates this block of switch statement
						
					case POINT:
						
						System.out.println( String.format( "[START] Your initial roll was a [%d]! Good luck!", initialRoll.getScore() ) ); // Begin game
						break;
						
						
					default: // Only here just in case there was an exception to rules; no cases of this occurring though
						
						System.out.println( "Default #1 for the gameResult switch statement; this shouldn't happen." );
						break;
				
				
				}
			
			} else {
				
				System.out.println( String.format( "Roll #%d - %d", rolls.size(), initialRoll.getScore() ) ); // Shows the roll is progressing with round
				
				switch( gameResult ) { // Switch statement #2 for every round OTHER than the initial
					
					case CRAPS: case NATURAL: case POINT: // Craps and Natural no longer end the round so they can all be checked for this.
						
						if ( initialRoll.getScore() == rolls.getFirst().getScore() ) { // Checks to see if the initial roll has been met again
							
							System.out.println( "[Winner] You've matched point; you win!" ); // Winner!
							continueRound = false; // Ends game loop
							
						} 
					
						break;
						
					case SEVEN_OUT: // Rolling a 7 will still cause a loss
						
						System.out.println( "[Loser] You've rolled a Seven-Out; you lose!" ); // Loser!
						continueRound = false;
						break;
						
					default: // Just in case to catch an exception; never occurred however
						
						System.out.println( "Default #2 for the gameResult switch statement; this shouldn't happen." );
						break;
						
			
				}			
				
			}
			
		}
		
		Init.QueryStart( "Play again?" ); // Restarts or exits the game based on user response.
		
	}
	
	private eGameResult shotResult( int score, boolean firstRound ) {
		
		if ( craps.contains( score ) ) { // Checks if the value is in the CRAPS list
			
			return eGameResult.CRAPS;
			
		} else if ( naturals.contains( score ) ) { // Chceks if the value is in the NATURALS list
			
			return ( firstRound || score == 11 ) ? eGameResult.NATURAL : eGameResult.SEVEN_OUT; // 7s can be a NATURAL on the first round, but a SEVEN_OUT on others
			
		} else if ( points.contains( score ) ) { // Checks if the value is in the POINT list
			
			return eGameResult.POINT;
			
		}
		
		return eGameResult.DEFAULT; // Has to return something; using in case of failure for above cases.
		
		
	}

	public int RollCount() {
		return rolls.size(); // No need to add to a rollCount variable since the list is already tracking the rolls
	}

}
