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
    public static  void move(int c){}
    //evaluates if the board is in a winning state
    public static  int  isWin(){}
    //prints out char representation of board
    public String toString{}

}
