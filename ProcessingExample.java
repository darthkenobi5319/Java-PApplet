package leohomework;
import processing.core.PApplet;

/**
 * This is the main program of ProcessingExample
 * This uses the Car class with it.
 * @author Zhenghan Zhang
 * @since 18 April, 2018
 */

@SuppressWarnings("serial")
public class ProcessingExample extends PApplet {	
	//dimensions of the canvas
	int xMax = 500;
	int yMax = 300;
	//instantiate a Car class
	Car car1 = new Car(xMax,yMax);
    float speedCoefficient;
	int carSize = 70;
	
	public void setup() 
	{	
		size(xMax,yMax);
		textSize(20);
		fill(0,0,0);
		textAlign(CENTER);
		text("Click a mouse button" , 250, 50); 
	}
	

	public void draw() {
		car1.borderDetection(xMax,yMax,carSize);
	if (mousePressed)
		{
			if (mouseButton == LEFT) {
				background(255,255,255); 
				fill(0,0,0);
				text("Step on the gas!" , 250, 250);		
				fill(255,0,0);	
				text("Click a mouse button", 250, 50); 
				speedCoefficient = 2;

			}
			else if (mouseButton == RIGHT  ) {
				background(255,255,255); 
				fill(0,0,0);
				text("Press on the break!" , 250, 250);
				fill(0,255,0);
				text("Click a mouse button" , 250, 50); 
				speedCoefficient = (float) 0.5;

			}
		}
	else{
		background(255,255,255); 
		fill(0,0,255);
		text("Click a mouse button", 250, 50); 
		speedCoefficient = 1;
	}	

		car1.moveCar(speedCoefficient);
		image(car1.car, car1.x, car1.y, carSize, carSize);	
	}

}
