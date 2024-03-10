// Time Complexity: O(log n) binary search, n -> length of nums array
// Space Complexity: O(1), no extra space used

// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        // let's do binary search here.
        // Idea: As it is rotated sorted array, so we need ot check for 3 conditions
        //      1: if nums[mid] >= nums[low], the that part is sorted, need to look at other part
        //      2: if nums[low] <= nums[high], return low as that is the smallest element
        //      3: if nums[low] >= nums[mid] && nums[high] >= nums[mid], then return nums[mid] as that is smallest element

        int low = 0;
        int high = nums.length -1;

        // stop when there is cross over
        while(high >= low) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }

            // if not, calculate mid
            int mid = (low + high)/2;

            if(nums[mid] >= nums[low]) {
                // then this part is sorted
                low = mid + 1;
            } else {
                // if that is not the case, then right side is sorted
                high = mid - 1;
            }

            // if mid is smaller than both the return it
            if(nums[low] >= nums[mid] && nums[high] >= nums[mid]){
                return nums[mid];
            }
        }
        return nums[low];
    }
}
