
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class rectangleDriver {
	int height;
	int width;

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		Rectangle [] array = new Rectangle [5];
		
		for (int i =0; i<array.length; i++) {
			array[i]= new Rectangle(rand.nextInt(100),rand.nextInt(100));
		}
//		for (int i =0; i<array.length; i++) {
//			System.out.println(array[i].getArea());
	//	}
		
		System.out.println(Arrays.toString(array));
		System.out.println(array[1].compareArea(array[1], array[2]));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(cmp.compare(arr[i], arr[maxIndex]) > 0)
			{
				maxIndex = i;
			}
		}

		return arr[maxIndex];
	}

}
