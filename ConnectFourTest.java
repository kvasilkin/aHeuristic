// trying minimax

public class ConnectFourTest{
    //Vars
    private    char [][] board;
    private boolean player; //true == red false = = black
    

    // class that stores and retrieves connect 4 states
    public DataSet storage;


    public int[] showMoves(){

    	// iterate through the top row to see remaining valid moves
    	
    	int[] out = int[7];
    	int len = 0;
    	for (int col; col < board[1].length; col++){
    		if (board[1][col] == ' '){
    			out[len] = col;
    			len ++;
    		}
    	}

    	// trim out to contain no null values?

    	return out;
    }

    // digs through dataset to find heuristic
    public float getHeurisiticStat(boolean player){
    	
    	// return % of wins from that position
    	// first check if win or loss--
    	if (player){
    		return storage.findProbability(board);
    	}
    	else{
    		return 1 - storage.findProbability(board);
    	}
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
    public int[][] returnAppliedMove(int c){

    }

    public float minimaxIteration(ConnectFourTest board, int depth, boolean player){//, float alpha, float beta){

    	if (depth == 0){
    		return board.getHeurisitic()
    	}

        // iff win return 999 if loss return -999
    	if (player){
    		bestVal = -999;
    		for (int nextMove : this.showMoves()){
    			// value of the node is found in... minimax   (new board pos., lowered depth, other team)
    			
    			val = minimaxIteration(board.returnAppliedMove(nextMove), depth - 1, false)
    			bestValue = Math.max(val, alpha)
    		}

            return bestValue
    	}
    	
    	else if (player == false){
    		bestVal = 999;
            for (int nextMove : this.showMoves()){
    			
    			val = minimaxIteration(board.returnAppliedMove(nextMove), depth - 1, true)
    			bestValue = Math.min(val, alpha)
    		}

            return bestValue
    	}



    	}
    }


}