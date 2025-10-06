// Time Complexity : O(log n) where n is the number of elements in the input array
// Space Complexity : O(1) as we do not use any extra space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Find minimum in rotated sorted array
 */

/*
 * Approach: Iterative Binary Search
 * In this approach, we use binary search to find the minimum element. The idea is that the min element will always lie in 
 * the unsorted half. We need to move away from the sorted half and try to find the min element in the unsorted half.
 */

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            } else {
                int mid = low + (high - low)/2;
                if (mid > 0 && nums[mid-1] > nums[mid]) {
                    return nums[mid];
                } else if (nums[low] <= nums[mid]) {
                    // left side sorted so move away
                    low = mid + 1;
                } else {
                    // right side sorted so move away
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {4,5,6,7,0,1,2};
        int[] arr3 = {11,13,15,17};

        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        System.out.println(findMinInRotatedSortedArray.findMin(arr1));
        System.out.println(findMinInRotatedSortedArray.findMin(arr2));
        System.out.println(findMinInRotatedSortedArray.findMin(arr3));
    }
}
