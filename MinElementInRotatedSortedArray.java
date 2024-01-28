// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:
*. If the array is rotated sorted array, definitely one half will be sorted.

 I will take a midIndex and checks which side of the array is sorted,

 1. if the left half is sorted, then check mid + 1 is smaller, if it is that is min element
 2. if not move the low pointer to mid + 1 (unsorted side of the array)

 3. if the right half is sorted, then check mid - 1 is greater, if it is mid is min element
 4. if not move the high pointer to mid - 1 (unsorted side of the array)

 make sure to place conditions to avoid out bound exception
 */
public class MinElementInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null && nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;

        if(nums[high] >= nums[low]) {
            return nums[low];
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[mid]) {
                if(mid < high) {
                    if(nums[mid + 1] > nums[mid]) {
                        low = mid + 1;
                    } else {
                        return nums[mid + 1];
                    }
                }
            } else {
                if(mid > low) {
                    if(nums[mid - 1] < nums[mid]) {
                        high = mid - 1;
                    } else {
                        return nums[mid];
                    }
                }
            }
        }
        return -1;
    }
}
