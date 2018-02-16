import java.util.Arrays;
import java.util.LinkedList;

public class Round {

	private eGameResult gameResult;
	
	private LinkedList<Roll> rolls = new LinkedList<Roll>();
	
	private LinkedList<Integer> craps = new LinkedList<Integer>( Arrays.asList( 2, 3, 12 ) );
	private LinkedList<Integer> naturals = new LinkedList<Integer>( Arrays.asList( 7, 11 ) );
	private LinkedList<Integer> points = new LinkedList<Integer>( Arrays.asList( 4, 5, 6, 8, 9, 10 ) );
	
	private boolean continueRound = true;
	
	
	public Round() {
		
		while ( continueRound ) {
		
			Roll initialRoll = new Roll();
			rolls.add( initialRoll );
		
			boolean isFirstRound = ( rolls.size() == 1 );
			
			gameResult = shotResult( initialRoll.getScore(), isFirstRound );
			
			if ( isFirstRound ) {
			
				switch( gameResult ) {
				
					case CRAPS: case NATURAL:
							
						System.out.println( String.format( "[ROUND OVER] Your initial roll was a [%d]! %s!", initialRoll.getScore(), gameResult ) );
						continueRound = false;
							
						break;
						
					case POINT:
						
						System.out.println( String.format( "[START] Your initial roll was a [%d]! Good luck!", initialRoll.getScore() ) );
						break;
						
						
					default:
						
						System.out.println( "Default #1 for the gameResult switch statement; this shouldn't happen." );
						break;
				
				
				}
			
			} else {
				
				System.out.println( String.format( "Roll #%d - %d", rolls.size(), initialRoll.getScore() ) );
				
				switch( gameResult ) {
					
					case CRAPS: case NATURAL: case POINT:
						
						if ( initialRoll.getScore() == rolls.getFirst().getScore() ) { 
							
							System.out.println( "[Winner] You've matched point; you win!" );
							continueRound = false;
							
						} 
					
						break;
						
					case SEVEN_OUT:
						
						System.out.println( "[Loser] You've rolled a Seven-Out; you lose!" );
						continueRound = false;
						break;
						
					default:
						
						System.out.println( "Default #2 for the gameResult switch statement; this shouldn't happen." );
						break;
						
			
				}			
				
			}
			
		}
		
		Init.QueryStart( "Play again?" );
		
	}
	
	private eGameResult shotResult( int score, boolean firstRound ) {
		
		if ( craps.contains( score ) ) { 
			
			return eGameResult.CRAPS; 
			
		} else if ( naturals.contains( score ) ) {
			
			return ( firstRound || score == 11 ) ? eGameResult.NATURAL : eGameResult.SEVEN_OUT;
			
		} else if ( points.contains( score ) ) {
			
			return eGameResult.POINT;
			
		}
		
		return eGameResult.DEFAULT; // Has to return something; using in case of failure for above cases.
		
		
	}

	public int RollCount() {
		return rolls.size();
	}

}
