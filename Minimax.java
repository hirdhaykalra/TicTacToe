/*
 * The University of North Carolina at Charlotte
 * ITCS 3153 - Intro to Artificial Intelligence
 * 
 * Programming Assignment 2 - Adversarial Search
 * 
 * Based on code from Dilip Kumar Subramanian
 * 
 * Modified by Julio C. Bahamon
 */

import java.util.ArrayList;


public class Minimax
{
	private static String AI_LETTER = "O";
	private static String PLAYER_LETTER = "X";
	
	/**
	 *
	 * This will recursively call Minimax depending on the current player, if the
	 * current player is O, the algorithm will find the MAX available board and if
	 * the current player is X, the algorithm will find the MIN avaiLable board.
	 * 
	 * We assume that the human player is X and that the AI is O
	 * 
	 * The terminal state check is done at the start before recursively calling
	 * Minimax, the terminal checks are checkWinner for player X(Human) and O(AI) and
	 * if the board state is full, if either of the conditions gets satisfied then
	 * it will return the value as decided if winner is AI(O), assign +1, if
	 * winner is User(X) assign -1 and if the state is draw assign 0 and return
	 *
	 * @param state
	 *            board for which the Minimax will be called recursively
	 * @param player
	 *            player for whom the game state should be generated
	 * @return int 
	 * 			  utility value 
	 **/
	public static int miniMax(GameState state, String player)
	{
		GameAI.setTotalCount(GameAI.getTotalCount() + 1);
		if(state.checkWinner(state.getBoardState(), PLAYER_LETTER))
		{
			return -1;
		}
		if(state.checkWinner(state.getBoardState(), AI_LETTER))
		{
			return 1;
		}
		if(state.boardFullCheck(state.getBoardState()))
		{
			return 0;
		}
		
		ArrayList<GameState> succ = new ArrayList<GameState>();
		succ = state.generateSuccessors(state, player);
		
		if(player == AI_LETTER)
		{
			double largest = Double.NEGATIVE_INFINITY;
			for(GameState x: succ)
			{
				int r = miniMax(x,PLAYER_LETTER);
				if(r>largest)
				{
					largest = r;
				}
			}
			//System.out.println("largest: " + largest);
			return (int)largest;
		}
		
		if(player == PLAYER_LETTER)
		{
			double smallest = Double.POSITIVE_INFINITY;
			for(GameState x: succ)
			{
				int r = miniMax(x,AI_LETTER);
				if(r<smallest)
				{
					smallest = r;
				}
				//System.out.println("smallest:" + smallest);
			}
			return (int)smallest;
		}
		
		return 0;
		
		
		//	TODO: Implement the minimax function
		
		/*	HINTS:
		 *  
		 *  Use Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY
		 *  for the initialization values
		 *  
		 *  Use the checkWinner method in GameState to check leaf nodes
		 *  
		 *  Use boardFullCheck method in GameState to check for tied games
		 *  
		 *  Use the printBoardStateMax to produce debug output
		 *  
		 */
		
		
//		DEBUG OUTPUT CODE
//		Log.debug("Inside maxValue " + " " + value);
//		Log.debug("Inside minValue " + " " + best);
		
		

	}
}