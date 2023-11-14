// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//uses a binary search approach, adjusting the search range based on the comparison
// between the middle element (m) and the element at the high index. The loop terminates when the low index
// reaches the minimum element, and the method returns that minimum element.

class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int m = (low + high) / 2;
            if (nums[m] < nums[high])
                high = m;
            else
                low = m + 1;
        }

        return nums[low];
    }
}

