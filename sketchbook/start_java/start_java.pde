final class ConnectFour{
final     char [][] board = new char [6][7];
       boolean player = true; //true == red false = = black
     //final int numPlayers;
  void setup() {
  size(700, 600);
  
  
 
  
//horiz

line(0, 100, 1000, 100);
line(0, 200, 1000, 200);
line(0, 300, 1000, 300);
line(0, 400, 1000, 400);
line(0, 500, 1000, 500);
//vert
line(100, 0, 100, 600);
line(200, 0, 200, 600);
line(300, 0, 300, 600);
line(400, 0, 400, 600);
line(500, 0, 500, 600);
line(600, 0, 600, 0);
 

  for (int r = 0; r < 6; r++){
      for (int c = 0; c < 7; c++ ){
    board[r][c] = 'o';
          }
        }
}
 
    //constructor


   


 
    


    //checks if coord is a valid move

    public   boolean isValidMove(int r,int c){

  if (c == 0){return  true;
  }
  if (board[r][c] == 'o' && board[r][c - 1] == 'o'){return  true;
  }
  return false;
    }
    
    //puts down a piece 
    public    String move(int c){
  for(int i = 5; i > -1; i--){
      if (board[i][c] == 'o'){
    if (player){
        board[i][c] = 'r';
    player = !player;
    if (isRedWin()){
        return "RED WON";
          }


    }
    else{
       board[i][c] = 'b';
  player = !player;
          if (isBlackWin()){
        return "BLACK WON";
          }  
  }      
  }
    }
return "input  next move"; }
    //evaluates if the board is in a winning state for red
    public   boolean    isRedWin(){
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
 public   boolean    isBlackWin(){
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
void draw() {
  if (mousePressed) {
ellipse(mouseX, mouseY, 50,50);
  }
  
} 
}