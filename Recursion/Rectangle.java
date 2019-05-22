
import java.lang.reflect.Array;
import java.util.Arrays;

public class Rectangle {
	int height;
	int width;
	
	
	
	

	public Rectangle(int height, int width) {
		
		this.height = height;
		this.width = width;
	}


	public int getHeight() {
		return height;
	}
	
	
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
	public int getArea () {
		int area = height*width;
		return area;
		
	}

	public int getPerimeter () {
		int perimiter = 2*(height+width);
		return perimiter;
	}
	
	public int maxArea(Rectangle[]a) {
		Arrays.sort(a);
		int maxArea = a[5].getArea();
		return maxArea;
	}

	
	
	
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width +","+ " area="+ getArea() + ", perimeter="+ getPerimeter()+"]"+"\n";
	}


	public int compareArea(Rectangle o1,Rectangle o2) {
	if (o1.getArea()>o2.getArea()) {
		return 0;
	}
	else
	return 1;

}
}
