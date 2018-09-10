
import processing.core.PApplet;
import processing.core.PImage;
/**
* This is a car class that stores the PImage and position and speed of the car
* Besides the consturctor, there is a reverse method that should reverse the car's position, so that
* when it hit the wall it would change its direction
* note that the car should be sized down to fit the canvas
* @author: Zhenghan Zhang
* @since: 18 April, 2018
*/

@SuppressWarnings("serial")
public class Car extends PApplet{
	PImage car;
	PImage car_r;
	float xi;
	float yi;
	float ai = 2;
	float bi = 1;
	float x;
	float y;

	/**
	 * The default constructor uses 500, and 300 as width and height
	 */
	public Car() {
		this(500,300);
	}
	/**
	*The constructor used for instantiating the "car" object
	* @param xMax the vertical extent of the canvas;
	* @param yMax the vertical extent of the canvas;
	* @throws NullPointerException: when the directory of the "car.png" is incorrect, throw null pointer exception.
	*/
	public Car(int xMax,int yMax) throws NullPointerException{
		x = (float) (xMax * Math.random());
		y = (float) (yMax * Math.random());
		car = loadImage("C:\\Users\\darth\\eclipse-workspace\\leohomework\\bin\\leohomework\\car.png");
		car_r = new PImage(car.width, car.height, ALPHA);
			for( int i=0; i < car.width; i++ ){
				for(int j=0; j < car.height; j++){
					car_r.set( car.width - 1 - i, j, car.get(i, j) );
				}
			}
	}

	/**
	*This method reverses the car into a reversed position;
	*/
	public void reverseCar(){
		PImage temp = new PImage(this.car.width, this.car.height, ALPHA);
		temp = this.car;
		this.car = this.car_r;
		this.car_r = temp;
	}

	/**
	* This method moves the car in designated speed
	* @param speedCoefficient the coefficient of speed: should be 0.5, 1 or 2;
	*/
	public void moveCar (float speedCoefficient){
		this.xi = speedCoefficient * this.ai;
		this.yi = speedCoefficient * this.bi;
		this.x += this.xi;
		this.y += this.yi;
	}

	/**
	*This method detects whether the car met the border, and make changes to its movements perspectively.
	* @param xMax the vertical extent of the canvas;
	* @param yMax the vertical extent of the canvas;
	* @param size the size of the car's image;
	*/
	public void borderDetection(int xMax,int yMax,int size){
		if (this.x >= xMax - (int) size/2 || this.x <= 0)
		{
			this.ai = -this.ai;
			reverseCar();
		}
		if (y >= yMax - (int) size/2 || y <= 0)
		{
			this.bi = -this.bi;
		}
	}

}