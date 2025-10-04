public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // Binary search loop
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            // If middle element is greater than rightmost element, the minimum is on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid; // The minimum could be at mid itself, so we include mid
            }
        }

        // At the end, left == right, and we return the element at that position
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums1)); // Output: 1

        // Example 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums2)); // Output: 0

        // Example 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(solution.findMin(nums3)); // Output: 11
    }
}

//Time Complexity : O(log n)
//Space Comlexity : O(1)