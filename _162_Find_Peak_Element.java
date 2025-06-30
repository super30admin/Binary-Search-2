/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we traverse the array and find out if it more than previous element and next element, if yes return it. Before we check the edge cases, if the start or end elements are max. and check if nums length is 1, then return the start element.

/**** Method 2 ****/
//Time Complexity: O(logn)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we do binary search, check the check if the mid element is greater than its , if yes return nums[mid]. Else move to a section of array which has greater element than nums[mid], as max will be present over there.

/**** Method 1 ****/
// public class _162_Find_Peak_Element {

//   public int findPeakElement(int[] nums) {
//     if (nums.length == 1) {
//       return 0;
//     }
//     int n = nums.length - 1;
//     if (nums[0] > nums[n]) {
//       return 0;
//     } else if (nums[n - 1] < nums[n]) {
//       return n;
//     } else {
//       for (int i = 1; i < nums.length - 1; i++) {
//         if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//           return i;
//         }
//       }
//     }

//     return -1;
//   }
// }

/**** Method 2 ****/
public class _162_Find_Peak_Element {

  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int n = nums.length;

    if (nums.length == 1) return 0;
    if (nums[0] > nums[1]) return 0;
    if (nums[n - 1] > nums[n - 2]) return n - 1;

    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (
        mid > 0 &&
        nums[mid - 1] < nums[mid] &&
        mid < n - 1 &&
        nums[mid] > nums[mid + 1]
      ) {
        return mid;
      } else if (nums[mid] < nums[mid + 1]) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return 43232;
  }
}
