	import java.util.*; 
		import java.io.*; 
public class ConnectFour {
    //Vars
    private    char [][] board;
    private boolean player; //true == red false = = black
    private int numPlayers;

    //constructor

    public void ConnectFour(int p){
	board = new char [7][6];
	numPlayers = p;
	player = true; //red
	for (int r = 0; r < 7; r++){
	    for (int c = 0; c < 6; c++ ){
		board[r][c] = 'x';
}}

}



 public void ConnectFour(){
	board = new char [7][6];
	numPlayers = 1;
	player = true; //red}
	for (int r = 0; r < 7; r++){
	    for (int c = 0; c < 6; c++ ){
		board[r][c] = 'x';
}}



    //checks if coord is a valid move

    public static  boolean isValidMove(int r,int c){
	boolean result = false;
	if (c == 0){result = true;}
	if (board[r][c] == 'x' && board[r][c - 1] == 'x'){result = true;}
	return result;
}
    //shows valid moves
    public static void showMoves(){

}
    

    //puts down a piece 
    public static  void move(int c){
	for(int i = 7; i > 0; i--){
	    if (board[c][i] == 'x'){
		board[c][i] = '0';
}
}
}
    //evaluates if the board is in a winning state
    public static  boolean   isWin(){
	for (int r= 0; r < 7; r++  ){
	    for (int c = 0; c < 6; c++){
		if (r < 4){
		    if (board [r][c] =='0' && board [r + 1][c] =='0' && board [r + 2][c] =='0' && board [r + 3][c] =='0' ){
			return true;
		    }
		}
		    if (c < 3){
		    if (board [r][c] =='0' && board [r][c + 1] =='0' && board [r ][c + 2] =='0' && board [r][c + 3] =='0' ){
			return true;
		    }
		    }

		    if ()
}
}
}
    //prints out char representation of board
    public String toString{}

}
