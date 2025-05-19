// TC: O(log n)
// SC: O(1)
// Approach: Binary Search 

public class Minimum_In_Rotated_Sorted_Array {

  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }

  public static void main(String[] args) {
    Minimum_In_Rotated_Sorted_Array obj = new Minimum_In_Rotated_Sorted_Array();
    int[] nums = new int[] { 3, 4, 5, 1, 2 };

    System.out.println("Minimum number in given array is " + obj.findMin(nums));
  }
}
