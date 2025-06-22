//time complexity : O(logn)
//space complexity: O(1)
class Solution 
{
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // Case 1: If the current subarray is already sorted, return the leftmost element
            // (smallest element in sorted range)
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;  // Prevents integer overflow

            // Case 2: Check if mid is the minimum element
            // It should be less than both its neighbors (handle edge cases at boundaries)
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            // Case 3: If left half is sorted, minimum must be in right half
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                // Otherwise, minimum lies in the left half
                high = mid - 1;
            }
        }

        return -1; // This line should never be reached for a valid rotated sorted array
    }
}
public class RotatedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Minimum in nums2: " + sol.findMin(nums1)); // Output: 1

        
    }
}
