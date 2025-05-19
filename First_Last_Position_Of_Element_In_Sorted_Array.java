// TC: O(ogn)
// SC: O(1)
// Approach:
// Brute Force - Linear search - O(n)
// Optimized - We will run 2 seperate binary search 
// In first we will find the first index of the target
// In second we will use firstIndex as low and run a binary search to find 2nd index

import java.util.Arrays;

public class First_Last_Position_Of_Element_In_Sorted_Array {

  private int binarySearchFirst(int[] nums, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if (mid == 0 || nums[mid] > nums[mid - 1]) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  private int binarySearchSecond(int[] nums, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
          return mid;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    if (nums == null || nums.length == 0)
      return new int[] { -1, -1 };
    if (target < nums[0] || target > nums[n - 1])
      return new int[] { -1, -1 };

    int firstIndex = binarySearchFirst(nums, 0, n - 1, target);
    if (firstIndex == -1)
      return new int[] { -1, -1 };
    int secondIndex = binarySearchSecond(nums, firstIndex, n - 1, target);
    return new int[] { firstIndex, secondIndex };
  }

  public static void main(String[] args) {
    First_Last_Position_Of_Element_In_Sorted_Array obj = new First_Last_Position_Of_Element_In_Sorted_Array();
    int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    
    System.out.println("First and last index of the target is " + Arrays.toString(obj.searchRange(nums, target)));
  }
}