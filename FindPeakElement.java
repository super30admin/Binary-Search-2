// Time Complexity : O(log n) where n is the number of elements in the input array
// Space Complexity : O(1) as we do not use any extra space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Find minimum in rotated sorted array
 */

/*
 * Approach: Iterative Binary Search
 * In this approach, we use binary search to find the peak element. We always incline to that half of the array
 * where the immediate neighbor of mid is greater than mid. If both neighbors are the same, we can move to any side.
 * If the element at mid is greater than both its neighbors then we have found the mid and we return it. We we do not
 * we move to the side where neighbor is higher.
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            // We handle the edge cases where the peak can be at very first or last index as well
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid; // this is the peak index
            } else if (nums[mid+1] > nums[mid]) {
                low = mid + 1; //move to the higher side
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1,2,1,3,5,6,4};
        FindPeakElement findPeakElement = new FindPeakElement();

        System.out.println(findPeakElement.findPeakElement(nums1));

        System.out.println(findPeakElement.findPeakElement(nums2));
    }
}
