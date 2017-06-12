import controlP5.*;
ControlP5 cp5;
  char [][] board = new char [6][7];
       boolean player = true; //true == red false = = black
    int[] row = new int[7];
   int timeStart;
   int rw, cw, tw;
         
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

 timeStart=millis(); 
  for (int r = 0; r < 6; r++){
      for (int c = 0; c < 7; c++ ){
    board[r][c] = 'o';
          }
        }
for (int k = 0; k < 7; k++) {
row[k] = 5;}
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
    strokeWeight(1);
   int i = row[c];
 
        if (player){
        board[i][c] = 'r'; 
    fill(#ED2424);
    ellipse(c * 100 + 50, i * 100 + 50, 50, 50);
    row[c] = row[c] - 1;   
    }
    else{
     fill(0);
    ellipse(c * 100 + 50, i * 100 + 50, 50, 50);
       board[i][c] = 'b';
 row[c] = row[c] - 1;
          
  }
  player = !player;
    }
  
    


    //evaluates if the board is in a winning state for red
    public   boolean    isRedWin(){
  for (int r= 0; r < 6; r++  ){
      for (int c = 0; c < 7; c++){
    if (r < 3){
        if (board [r][c] =='r' && board [r + 1][c] =='r' && board [r + 2][c] =='r' && board [r + 3][c] =='r' ){
      tw = 1;
      rw = r;
      cw = c;
          return true;
        }
    }
    if (c < 4){
        if (board [r][c] =='r' && board [r][c + 1] =='r' && board [r ][c + 2] =='r' && board [r][c + 3] =='r' ){
      tw = 2;
      rw = r;
      cw = c;
          return true;
        }
    }

      
      }
  }
    
  for (int r = 0; r < 3; r++){
      for (int c = 0; c < 4; c++){
    if (board [r][c] =='r' && board [r + 1][c +1 ] =='r' && board [r + 2][c +2] =='r' && board [r + 3][c +3 ] =='r' ){
       tw = 3;
      rw = r;
      cw = c;  
    return true; }
      }
  }

  for (int r = 0; r < 3 ; r++){
      for (int c = 6; c > 2; c--){
    if (board [r][c] =='r' && board [r + 1][c - 1 ] =='r' && board [r + 2][c - 2] =='r' && board [r + 3][c - 3 ] =='r' ){
       tw = 4;
      rw = r;
      cw = c;   
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
      tw = 1;
      rw = r;
      cw = c;
          return true;
        }
    }
    if (c < 4){
        if (board [r][c] =='b' && board [r][c + 1] =='b' && board [r ][c + 2] =='b' && board [r][c + 3] =='b' ){
     tw = 2;
      rw = r;
      cw = c;
          return true;
        }
    }

      
      }
  }
    
  for (int r = 0; r < 3; r++){
      for (int c = 0; c < 4; c++){
    if (board [r][c] =='b' && board [r + 1][c +1 ] =='b' && board [r + 2][c +2] =='b' && board [r + 3][c +3 ] =='b' ){
       tw = 3;
      rw = r;
      cw = c;    
    return true; }
      }
  }

  for (int r = 0; r < 3 ; r++){
      for (int c = 6; c > 2; c--){
    if (board [r][c] =='b' && board [r + 1][c - 1 ] =='b' && board [r + 2][c - 2] =='b' && board [r + 3][c - 3 ] =='b' ){
       tw = 4;
      rw = r;
      cw = c; 
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
  if (!player){
  int q = ConnectFourTest.returnAIMove(board, 4);
  move(q);
  }
  
  
  
  if (isBlackWin()){
 stroke(#0B38AF); 
 strokeWeight(10);
if (tw == 2){ 
   line(cw * 100 + 50, rw * 100 + 50, (cw +  3) * 100 + 50, rw  * 100 + 50);
 }
 if (tw == 1){
     line(cw * 100 + 50, rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50);
 }
 if (tw == 3){
    line(rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50, (cw - 3) * 100 + 50);
 }
 if (tw == 4){
    line(rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50, (cw + 3) * 100 + 50);
 }
  }
if (isRedWin()){
 stroke(#0B38AF);
 strokeWeight(10);
 if (tw == 2){ 
   line(cw * 100 + 50, rw * 100 + 50, (cw +  3) * 100 + 50, rw  * 100 + 50);
 }
 if (tw == 1){
     line(cw * 100 + 50, rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50);
 }
 if (tw == 3){
    line(rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50, (cw - 3) * 100 + 50);
 }
 if (tw == 4){
    line(rw * 100 + 50, cw * 100 + 50, (rw + 3) * 100 + 50, (cw + 3) * 100 + 50);
 } }
}

  void R1A()   // Function is automatically made with name in quotes
{if(millis()-timeStart<1000){return;}
   move(0);
}

  void R2A()   
{if(millis()-timeStart<1000){return;}
   move(1);
}

  void R3A()   
{if(millis()-timeStart<1000){return;}
   move(2);
}
  void R4A()  
{if(millis()-timeStart<1000){return;}
   move(3);
}
  void R5A()   
{if(millis()-timeStart<1000){return;}
   move(4);
}
  void R6A()   
{if(millis()-timeStart<1000){return;}
   move(5);
}
  void R7A()   
{if(millis()-timeStart<1000){return;}
   move(6);
}