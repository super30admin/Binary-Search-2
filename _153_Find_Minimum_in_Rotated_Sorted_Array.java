/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we traverse the array and find out if it less than previous element and next element, if yes return it. Before we check the edge cases, if the start or end elements are min. and check if nums length is 1, then return the start element.

/**** Method 2 ****/
//Time Complexity: O(logn)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we do binary search, check the check if the mid element is less than its , if yes return nums[mid]. else move to non-sorted section of array, as minimum will be present over there.

/**** Method 1 ****/
// public class _153_Find_Minimum_in_Rotated_Sorted_Array {

//   public int findMin(int[] nums) {

//     if (nums.length == 1) {
//       return nums[0];
//     }
//     int n = nums.length - 1;
//     if (nums[0] < nums[n]) {
//       return nums[0];
//     } else if (nums[n - 1] > nums[n]) {
//       return nums[n];
//     } else {
//       for (int i = 1; i < nums.length - 1; i++) {
//         if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
//           return nums[i];
//         }
//       }
//     }

//     return -1;
//   }
// }

/**** Method 2 ****/
public class _153_Find_Minimum_in_Rotated_Sorted_Array {

  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo <= hi) {
      if (nums[lo] <= nums[hi]) {
        return nums[lo];
      }

      int mid = lo + (hi - lo) / 2;

      if (
        (mid == 0 || nums[mid] < nums[mid - 1]) &&
        (mid == nums.length - 1 || nums[mid] < nums[mid + 1])
      ) {
        return nums[mid];
      } else if (nums[mid] < nums[lo]) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }
}
