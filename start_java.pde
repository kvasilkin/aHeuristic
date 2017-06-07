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
line(600, 0, 600, 600);
}

void draw() {
  if (mousePressed) {
ellipse(mouseX, mouseY, 50,50);
  }
  
  
}