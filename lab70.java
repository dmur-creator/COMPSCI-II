import java.util.Arrays;
public class lab70 {

	public static void main(String[] args) {
		int[] printNums = createArray();
		int smallestNums = findSmallest();

		System.out.println(Arrays.toString(printNums));
		System.out.println(smallestNums);
		
	}



public static int[] createArray() {
	int[] nums = new int[] {23,79,41,68,17,39,51,75,95,17};
	return nums;

	}


public static int findSmallest() {
	int[] nums = createArray();

	int min = nums[0];
	int indexOfMax = 0;
	for (int i = 1; i < nums.length; i++) {
		if (nums[1] < min) min = nums[i];
		System.out.println(min);
		}
	return min;

}
}