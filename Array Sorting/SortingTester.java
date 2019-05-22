package assignment7;
import java.util.Arrays;

public class SortingTester {

	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		System.out.println("          Unsorted: " + Arrays.toString(a1) + "\n");

		Integer[] a2 = a1.clone();//used to copy unsorted version
		SortingMethods.insertSort(a2);
		System.out.println("  Insertion Sorted: " + Arrays.toString(a2) + "\n");

		/*
		Integer[] small = new Integer[]{13,12,11,10,9,8,7,6,5,4,3,2,1};
		SortingMethods.insertSort(small);
		System.out.println("  Insertion Sorted: " + Arrays.toString(small) + "\n");
		*/

		Integer[] a3 = a1.clone();//used to copy unsorted version
		SortingMethods.shellSort(a3);
		System.out.println("      Shell Sorted: " + Arrays.toString(a3) + "\n");

		/*
		Integer[] small2 = new Integer[]{13,12,11,10,9,8,7,6,5,4,3,2,1};
		SortingMethods.shellSort(small2);
		System.out.println("      Shell Sorted: " + Arrays.toString(small2) + "\n");
		*/

		Integer[] a4 = a1.clone();//used to copy unsorted version
		SortingMethods.heapSort(a4);
		System.out.println("Binary Heap Sorted: " + Arrays.toString(a4) + "\n");

		Integer[] a5 = a1.clone();//used to copy unsorted version
		SortingMethods.mergeSort(a5);
		System.out.println("      Merge Sorted: " + Arrays.toString(a5) + "\n");

		Integer[] a6 = a1.clone();//used to copy unsorted version
		SortingMethods.quickSort(a6);
		System.out.println("      Quick Sorted: " + Arrays.toString(a6) + "\n");

		/*
		Integer[] small3 = new Integer[]{13,12,11,10,9,8,7,6,5,4,3,2,1};
		SortingMethods.quickSort(small3);
		System.out.println("      Quick Sorted: " + Arrays.toString(small3) + "\n");
		*/

		Integer[] a7 = a1.clone();//used to copy unsorted version
		SortingMethods.bucketSort(a7, 11, 96);//O(N+M) = O(13+86)
		System.out.println("     Bucket Sorted: " + Arrays.toString(a7) + "\n");

		String[] s1 = new String[]{"biy", "auz", "csx", "caz"};
		SortingMethods.radixSortSameLength(s1, 3);
		System.out.println("     Radix Sorted: " + Arrays.toString(s1) + "\n");


		String[] s2 = new String[]{"ball", "auz", "csxpp","aa","qe","qqq"};
		//String[] s2 = new String[]{"ball", "auz", "csxpp", "zd"};

		SortingMethods.radixSortDifferentLength(s2);
		System.out.println("     Radix Any Length Sorted: " + Arrays.toString(s2) + "\n");





	}

}
