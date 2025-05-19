// TC: O(log n)
// SC: O(1)
// Approach:
// Brute Force - Linear serach - O(n)
// Optimized - Implement Binary Search
// Check if mid id greater than its neighbors return mid 
// Check move to either side where element is greater than mid 

public class Find_Peak_Element {

  public int findPeakElement(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
          (mid == nums.length - 1 || (nums[mid] > nums[mid + 1]))) {
        return mid;
      } else if (nums[mid + 1] > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Find_Peak_Element obj = new Find_Peak_Element();
    int[] nums = new int[] { 1, 2 };

    System.out.println("Peak element in array is " + obj.findPeakElement(nums));
  }
}
