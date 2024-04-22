import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

	// declare a global image variable
	PImage imgCar; 
  PImage imgRaceTrack;

  // set the starting coordinates for the car;
  float fltCarX = 100;
  float fltCarY = 150;
  
  // set the starting x and y coordinates for the circle
  float fltCircleX = 120;
  float fltCircleY = 140;

  // set speed of circle
  float fltCircleSpeedX = 3;
  float fltCircleSpeedY = 1;

  // set speed of car
  float fltCarSpeedX = 2;
  float fltCarSpeedY = 2;
  
  // defind radius and angle for car travel path
  float fltRadius;
  int intAngle = 0;

  public void settings() {

	// size call
    size(400, 400);

  }

  public void setup() {

    // load background into the program
    imgRaceTrack = loadImage("RaceTrack.jpeg");
    // resize background
    imgRaceTrack.resize(width, height);

    // load the car image into the program
    imgCar = loadImage("Car.png");

    // resize car
    imgCar.resize(imgCar.width/4, imgCar.height/4);
    fltRadius = 400/2 - Math.max(imgCar.width/2, imgCar.height/2);
  }

  public void draw() {

    // draw background
    background(imgRaceTrack);
 
    // draw the car moving in a circle
    float y = sin((float)Math.toRadians(intAngle)) * fltRadius + fltRadius;
    float x = cos((float)Math.toRadians(intAngle)) * fltRadius + fltRadius;

    image(imgCar, x, y);

    intAngle += 3;
    if (intAngle > 360) {
      intAngle = 0;
    }

    // draw the moving circle
    circle(fltCircleX, fltCircleY, 50);
    fltCircleX += fltCircleSpeedX;
    
    // set restrictions for the circle
    if (fltCircleX < 10 || fltCircleX > width - 10) {
      fltCircleSpeedX *= -1;
    }

    if (fltCircleSpeedY < 10 || fltCircleSpeedY > height - 10) {
      fltCircleSpeedY *= -1;
    }

  }
}