import java.util.*; 
import java.io.*; 
public class ConnectFour {
    //Vars
    private static     char [][] board = new char [6][7];
    private static boolean player; //true == red false = = black
    private static int numPlayers;

    //constructor

    public  ConnectFour(int p){
	//board = new char [7][6];
	numPlayers = p;
	player = true; //red
	for (int r = 0; r < 6; r++){
	    for (int c = 0; c < 7; c++ ){
		board[r][c] = 'o';
	    }
	}

    }


    public  ConnectFour(){
	//board = new char [7][6];
	numPlayers = 2;
	player = true; //red}
	for (int r = 0; r < 6; r++){
	    for (int c = 0; c < 7; c++ ){
		board[r][c] = 'o';
	    }
	}
    }
    


    //checks if coord is a valid move

    public   boolean isValidMove(int r,int c){

	if (c == 0){return  true;
	}
	if (board[r][c] == 'o' && board[r][c - 1] == 'o'){return  true;
	}
	return false;
    }
    
    //puts down a piece 
    public   boolean move(int c){
	for(int i = 5; i > -1; i--){
	    if (board[i][c] == 'o'){
		if (player){
		    board[i][c] = 'r';
		player = !player;
		return true;}
		else{
		   board[i][c] = 'b';
	player = !player;
	return true;	
	}    	
	}
    }
return player; }
    //evaluates if the board is in a winning state for red
    public static  boolean    isRedWin(){
	for (int r= 0; r < 7; r++  ){
	    for (int c = 0; c < 6; c++){
		if (r < 4){
		    if (board [r][c] =='r' && board [r + 1][c] =='r' && board [r + 2][c] =='r' && board [r + 3][c] =='r' ){
			return true;
		    }
		}
		if (c < 3){
		    if (board [r][c] =='r' && board [r][c + 1] =='r' && board [r ][c + 2] =='r' && board [r][c + 3] =='r' ){
			return true;
		    }
		}

		  
	    }
	}
    
	for (int r= 0; r < 4; r++){
	    for (int c = 0; c < 3; c++){
		if (board [r][c] =='r' && board [r + 1][c +1 ] =='r' && board [r + 2][c +2] =='r' && board [r + 3][c +3 ] =='r' ){
		    return true; }
	    }
	}

	for (int r = 6; r > 7 ; r--){
	    for (int c = 0; c < 3; c++){
		if (board [r][c] =='r' && board [r - 1][c - 1 ] =='r' && board [r - 2][c - 2] =='r' && board [r - 3][c - 3 ] =='r' ){
		    return true; }
	    }
	}
	return false;
    }
 








    //checks if board is in a winnign state for black
    public static  boolean    isBlackWin(){
	for (int r= 0; r < 7; r++  ){
	    for (int c = 0; c < 6; c++){
		if (r < 4){
		    if (board [r][c] =='b' && board [r + 1][c] =='b' && board [r + 2][c] =='b' && board [r + 3][c] =='b' ){
			return true;
		    }
		}
		if (c < 3){
		    if (board [r][c] =='b' && board [r][c + 1] =='b' && board [r ][c + 2] =='b' && board [r][c + 3] =='b' ){
			return true;
		    }
		}

		  
	    }
	}
    
	for (int r= 0; r < 4; r++){
	    for (int c = 0; c < 3; c++){
		if (board [r][c] =='b' && board [r + 1][c +1 ] =='b' && board [r + 2][c +2] =='b' && board [r + 3][c +3 ] =='b' ){
		    return true; }
	    }
	}

	for (int r = 6; r > 7 ; r--){
	    for (int c = 0; c < 3; c++){
		if (board [r][c] =='b' && board [r - 1][c - 1 ] =='b' && board [r - 2][c - 2] =='b' && board [r - 3][c - 3 ] =='b' ){
		    return true; }
	    }
	}
	return false; }
 



    //prints out char representation of board
    public  String toString(){
	String result = "";
	    for (int r = 0; r < 6; r++){
		for (int c = 0; c < 7; c++ ){
		    result +=  " " + board[r][c];
		}
		result += '\n';
	    }
	return result;
    }

    public static void main(String[] args) {
ConnectFour field = new ConnectFour();
//System.out.println(field.toString());

field.move(3);
field.move(4);
field.move(3);
field.move(5);
field.move(3);
field.move(5);
field.move(3);

System.out.println(field.toString());
 //System.out.println(Arrays.deepToString(board));
//field.move(3);
//System.out.println(field);


    }
}