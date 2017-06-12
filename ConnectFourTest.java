// trying minimax

import java.lang.Math;
public class ConnectFourTest{
    //Vars
    // private char [][] board; // to be replaced with static function calls/
    // private boolean player; //true == red, human ;  false == black, computer
    

    // class that stores and retrieves connect 4 states
    // public DataSet storage;


    public static int[] showMoves(char[][] board){

    	// iterate through the top row to see remaining valid moves
    	
    	int[] out = new int[7];
    	int len = 0;
    	for (int col = 0; col < board[0].length; col++){
    		if (board[1][col] == ' '){
    			out[len] = col;
    			len ++;
    		}
    	}

    	// trim out to contain no null values
        int[] trimmed = new int[len];
        for (int col = 0; col < 7 ; col++){
            if (out[col] != 0){
                trimmed[col] = out[col];
            }
        }
    	return trimmed;
    }

    // digs through dataset to find heuristic // implement if time 
    // public double getHeurisiticStat(boolean player){
    	
    	// return % of wins from that position
    	// first check if win or loss--
    	
        // finish storage.findProbability() if time:
        // if (player){
    	// 	return storage.findProbability(board);
    	// }
    	// else{
    	// 	return 1 - storage.findProbability(board);
    	// }

        // return 0.0;
    // }

    // finds if winning move
    // public double getHeurisitic(boolean player){
    //     if (player){
    //         // return +1000 if winning move
    //     }
    //     else{
    //         // return -1000 if enemy winning move
    //     }
    // }


    // return board with new piece put at col c
    public static char[][] returnAppliedMove(char[][] board, int c, boolean team){

        char[][] out = new char[7][6];
        for (int row = 0; row < out.length; row++){
            for (int col = 0; col < out[row].length; col++){
                out[row][col] = board[row][col];
            }
        }
        
        // starting from the bottom, check for space and return
        for (int row = 0; row < board.length; row++){
            if (board[row][c] == ' '){
                
                // if human, place red, else place black
                if (team){
                    out[row][c] = 'r';
                    return out;
                }
                else{
                    out[row][c] = 'b';
                    return out;
                }
            }

        }
        return out;

    }

    public static int returnAIMove(char[][] board, int depth){
        
        
        int maxFitnessMove = 3; // default middle
        double maxFitnessSeen = -999.0;

        // finds and returns maximum fitness move
        for (int col : showMoves(board)){

            //                                                team false = computer
            double movefitness = minimaxIteration(returnAppliedMove(board, col, false), depth, true);
            System.out.println("fitness for col " + col );
            System.out.println(movefitness);
            if (movefitness > maxFitnessSeen){
                maxFitnessSeen = movefitness;
                maxFitnessMove = col;
            }
        }

        return maxFitnessMove;

    }

    // unnec. implement
    // return true if win, false if not
    // public boolean isWinningMoveSpot(char[][] board, int nextMove, boolean player){
    //     for (int row = 0; row < board.length ; row++){
    //         if (board[row][nextMove] == ' '){
    //             return checkSpotSolution(board, row, nextMove);
    //         }
    //     }
    //     return false;
    // }


    public static boolean isWinningMoveWhole(char[][] board, int nextMove, boolean player){
        // for (int row = 0; row < board.length ; row++){
        //     if (board[row][nextMove] == ' '){
        //         if (player){
        //             board[row][nextMove] = 'r';
        //             return isRedWin(returnAppliedMove(board, nextMove, true);
        //         }
        //         else{
        //             board[row][nextMove] = 'b';
        //             return isBlackWin(returnAppliedMove(board, nextMove, true);
        //         }

        //     }
        // }

        if (player){
            return isRedWin(returnAppliedMove(board, nextMove, true));
        }
        else{
            return isBlackWin(returnAppliedMove(board, nextMove, false));
        }
    }

    
    public static double minimaxIteration(char[][] board, int depth, boolean player){//, float alpha, float beta){


        // implement
        // if ran out of depth return probabilistic fitness
    	// if (depth == 0){
    	// 	return board.getHeurisitic();
    	// }

        // if win return 999 if loss return -999
    	

        if (depth == 0){
            return 0;
        }
        if (player == false){
    		double bestVal = -999.0;

    		for (int nextMove : showMoves(board)){
    			// value of the node is found in... minimax   (new board pos., lowered depth, other team)
    			if (isWinningMoveWhole(board, nextMove, false)){
                    return 1000;
                }
                else{
                    double val = minimaxIteration(returnAppliedMove(board, nextMove, false), depth - 1, true);
                    bestVal = Math.max(val, bestVal);
                }
            }
            return bestVal;
    	}
    	
        // if human 
        else{
    		double bestVal = 999.0;
            for (int nextMove : showMoves(board)){
    			if (isWinningMoveWhole(board, nextMove, true)){
                    return -1000;
                }
                else{
        			double val = minimaxIteration(returnAppliedMove(board, nextMove, true), depth - 1, false);
        			bestVal = Math.min(val, bestVal);
                }
            }
            return bestVal;
    	}
	}

// ---------------------------------------
    public static  boolean    isRedWin(char[][] board){
    for (int r= 0; r < 6; r++  ){
        for (int c = 0; c < 7; c++){
        if (r < 3){
            if (board [r][c] =='r' && board [r + 1][c] =='r' && board [r + 2][c] =='r' && board [r + 3][c] =='r' ){
            return true;
            }
        }
        if (c < 4){
            if (board [r][c] =='r' && board [r][c + 1] =='r' && board [r ][c + 2] =='r' && board [r][c + 3] =='r' ){
            return true;
            }
        }

          
        }
    }
    
    for (int r = 0; r < 3; r++){
        for (int c = 0; c < 4; c++){
        if (board [r][c] =='r' && board [r + 1][c +1 ] =='r' && board [r + 2][c +2] =='r' && board [r + 3][c +3 ] =='r' ){
            return true; }
        }
    }

    for (int r = 0; r < 3 ; r++){
        for (int c = 6; c > 2; c--){
        if (board [r][c] =='r' && board [r + 1][c - 1 ] =='r' && board [r + 2][c - 2] =='r' && board [r + 3][c - 3 ] =='r' ){
            return true; }
        }
    }
    return false;
    }
 








    //checks if board is in a winnign state for black
 public static  boolean    isBlackWin(char[][] board){
    for (int r= 0; r < 6; r++  ){
        for (int c = 0; c < 7; c++){
        if (r < 3){
            if (board [r][c] =='b' && board [r + 1][c] =='b' && board [r + 2][c] =='b' && board [r + 3][c] =='b' ){
            return true;
            }
        }
        if (c < 4){
            if (board [r][c] =='b' && board [r][c + 1] =='b' && board [r ][c + 2] =='b' && board [r][c + 3] =='b' ){
            return true;
            }
        }

          
        }
    }
    
    for (int r = 0; r < 3; r++){
        for (int c = 0; c < 4; c++){
        if (board [r][c] =='b' && board [r + 1][c +1 ] =='b' && board [r + 2][c +2] =='b' && board [r + 3][c +3 ] =='b' ){
            return true; }
        }
    }

    for (int r = 0; r < 3 ; r++){
        for (int c = 6; c > 2; c--){
        if (board [r][c] =='b' && board [r + 1][c - 1 ] =='b' && board [r + 2][c - 2] =='b' && board [r + 3][c - 3 ] =='b' ){
            return true; }
        }
    }
    return false;
    }

}


