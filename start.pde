import controlP5.*;
ControlP5 cp5;
  char [][] board = new char [6][7];
       boolean player = true; //true == red false = = black
    int[] row = new int[7];
   
         
     //final int numPlayers;
  void setup() {
size(700, 700);
//horiz
line(0, 100, 1000, 100);
line(0, 200, 1000, 200);
line(0, 300, 1000, 300);
line(0, 400, 1000, 400);
line(0, 500, 1000, 500);
line(0, 600, 1000, 600);
//vert
line(100, 0, 100, 600);
line(200, 0, 200, 600);
line(300, 0, 300, 600);
line(400, 0, 400, 600);
line(500, 0, 500, 600);
line(600, 0, 600, 600);


  for (int r = 0; r < 6; r++){
      for (int c = 0; c < 7; c++ ){
    board[r][c] = 'o';
          }
        }
for (int k = 0; k < 7; k++) {
row[k] = 6;}
cp5 = new ControlP5(this);
  
  // create a new button with name 'buttonA'
  cp5.addButton("R1A")
     .setValue(0)
     .setPosition(0,600)
     .setSize(100,100)
     ;
  cp5.addButton("R2A")
     .setValue(0)
     .setPosition(100,600)
     .setSize(100,100)
     ;
     
       cp5.addButton("R3A")
     .setValue(0)
     .setPosition(200,600)
     .setSize(100,100)
     ;
       cp5.addButton("R4A")
     .setValue(0)
     .setPosition(300,600)
     .setSize(100,100)
     ;
   cp5.addButton("R5A")
     .setValue(0)
     .setPosition(400,600)
     .setSize(100,100)
     ;

   cp5.addButton("R6A")
     .setValue(0)
     .setPosition(500,600)
     .setSize(100,100)
     ;
   cp5.addButton("R7A")
     .setValue(0)
     .setPosition(600,600)
     .setSize(100,100)
     ;

}



 public   boolean isValidMove(int r,int c){

  if (c == 0){return  true;
  }
  if (board[r][c] == 'o' && board[r][c - 1] == 'o'){return  true;
  }
  return false;
    }
    //puts down a piece 
    public    void  move(int c){
   int i = row[c];
 
        if (player){
        board[c][i] = 'r'; 
    fill(0);
    ellipse(c * 100 + 50, mouseY/100, 50, 50);
    row[c]--;   
    }
    else{
     fill(#ED2424);
      ellipse(c * 100 + 50, mouseY/100, 50, 50);
       board[c][i] = 'b';
 row[c]--;
          
  }
  player = !player;
    }
  
    


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
  


  }
  
}