// Time Complexity : O(2logn) ~ O(log n)
// Space Complexity : O(1) as we do not use any extra space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: First and Last position of a target in sorted array
 */

/*
* Approach: Two Binary Searches
* In the following approach, we need to find the first and last index of the target in a sorted array.
* We use two binary searches, one to find the first index of the target and another to find the last index of the target.
* If the target falls out of range of the sorted array, we return -1 as the first and last index. 
* The algo for first binary search slightly differs from the other binary search in that to find the first index based on the
* previous values and the last index based on the next values.
*/

public class FindFirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || n == 0) return new int[] {-1, -1};
        if (target < nums[0]) return new int[] {-1, -1};
        if (target > nums[n-1]) return new int[] {-1, -1};
        int firstIdx = binarySearchFirst(nums, 0, n-1, target);
        if (firstIdx == -1) return new int[] {-1, -1};
        int lastIdx = binarySearchLast(nums, firstIdx, n-1, target);
        return new int[] {firstIdx, lastIdx};
    }

    public int binarySearchFirst(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public int binarySearchLast(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                if (mid == right || nums[mid+1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int target2 = 6;

        FindFirstAndLastPositionInSortedArray findFirstAndLastPositionInSortedArray = new FindFirstAndLastPositionInSortedArray();
        
        int[] result1 = findFirstAndLastPositionInSortedArray.searchRange(nums1, target1);
        System.out.println("Result: " + result1[0] + ", " + result1[1]);

        int[] result2 = findFirstAndLastPositionInSortedArray.searchRange(nums1, target2);
        System.out.println("Result: " + result2[0] + ", " + result2[1]);

        int[] nums2 = {};
        int target3 = 0;
        int[] result3 = findFirstAndLastPositionInSortedArray.searchRange(nums2, target3);
        System.out.println("Result: " + result3[0] + ", " + result3[1]);

    }
}

