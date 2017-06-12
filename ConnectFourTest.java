// trying minimax

public class ConnectFourTest{
    //Vars
    private char [][] board; // to be replaced with static function calls
    private boolean player; //true == red, human ;  false == black, computer
    

    // class that stores and retrieves connect 4 states
    public DataSet storage;


    public static int[] showMoves(int[][] board){

    	// iterate through the top row to see remaining valid moves
    	
    	int[] out = int[7];
    	int len = 0;
    	for (int col = 0; col < board[0].length; col++){
    		if (board[1][col] == ' '){
    			out[len] = col;
    			len ++;
    		}
    	}

    	// trim out to contain no null values
        int[] trimmed = int[len];
        for (int col = 0; col < 7 ; col++){
            if (out[col] != null){
                trimmed[col] = out[col];
            }
        }
    	return trimmed;
    }

    // digs through dataset to find heuristic // implement if time 
    public float getHeurisiticStat(boolean player){
    	
    	// return % of wins from that position
    	// first check if win or loss--
    	
        // finish storage.findProbability() if time:
        // if (player){
    	// 	return storage.findProbability(board);
    	// }
    	// else{
    	// 	return 1 - storage.findProbability(board);
    	// }

        return 0.0;
    }

    // finds if winning move
    public float getHeurisitic(boolean player){
        if (player){
            // return +1000 if winning move
        }
        else{
            // return -1000 if enemy winning move
        }
    }


    // return board with new piece put at col c
    public static int[][] returnAppliedMove(int[][] board, int c, boolean team){

        out = int[7][6];
        for (int row = 0; row < out.length; row++){
            for (int col = 0; col < out[row].length; col++){
                out[row][col] = board[row][col];
            }
        }
        
        // starting from the bottom, check for space and return
        for (int row = 0; row < board.length; row++){
            if (board[row][col] == ' '){
                
                // if human, place red, else place black
                if (team){
                    out[row][col] = 'r';
                    return out;
                }
                else{
                    out[row][col] = 'b';
                    return out;
                }
            }

        }

    }

    public int returnAIMove(){
        
        
        maxFitnessMove = 3 // default middle
        maxFitnessSeen = -999

        // finds and returns maximum fitness move
        for (int col : this.showMoves()){

            //                                                team false = computer
            movefitness = minimaxIteration(returnAIMove(board, col), depth, false);
            
            if (movefitness > maxFitnessSeen){
                maxFitnessSeen = movefitness;
                maxFitnessMove = col;
            }
        }

        return maxFitnessMove;

    }

    // nec. implement
    // return true if win, false if not
    public boolean isWinningMoveSpot(int[][] board, int nextMove, boolean player){
        for (int row = 0; row < board.length ; row++){
            if (board[row][col] = ' '){
                return checkSpotSolution(board, row, col);
            }
        }
        return false;
    }

    public boolean isWinningMoveWhole(int[][] board, int nextMove, boolean player){
        for (int row = 0; row < board.length ; row++){
            if (board[row][col] = ' '){
                if player{
                    board[row][col] = 'r';
                    return isRedWin(board);
                }
                else{
                    board[row][col] = 'b';
                    return isBlackWin(board);
                }

            }
        }
        return false;
    }

    
    public float minimaxIteration(ConnectFourTest board, int depth, boolean player){//, float alpha, float beta){


        // implement
        // if ran out of depth return probabilistic fitness
    	// if (depth == 0){
    	// 	return board.getHeurisitic();
    	// }

        // if win return 999 if loss return -999
    	
        if (player == false){
    		bestVal = -999;

    		for (int nextMove : showMoves(board)){
    			// value of the node is found in... minimax   (new board pos., lowered depth, other team)
    			if (isWinningMove(board, nextMove, false)){
                    return 1000;
                }
                else{
                    val = minimaxIteration(returnAppliedMove(board, nextMove, false), depth - 1, true);
                    bestValue = Math.max(val, bestValue);
                }
            }
            return bestValue;
    	}
    	
        // if human 
        else{
    		bestVal = 999;
            for (int nextMove : showMoves(board)){
    			if (isWinningMove(board, nextMove, true)){
                    return -1000;
                }
                else{
        			val = minimaxIteration(board.returnAppliedMove(nextMove), depth - 1, false);
        			bestValue = Math.min(val, bestValue);
                }
            }
            return bestValue;
    	}
	}

}
