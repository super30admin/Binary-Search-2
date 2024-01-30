//time complexity: O(log n)
//space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : condition check

//Find peak element which is higher than both of its adjecents
// Always traverse toward the highest element

public class FindPeak {

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;
        int len = nums.length;
        int low = 0;
        int high = nums.length - 1;

        if (len == 1)
            return nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if(nums[len-1] > nums[len-2]) return len-1;

            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == len - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid != 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;

    }
}
