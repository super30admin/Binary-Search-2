// Time Complexity: O(log n) binary search, n -> length of nums array
// Space Complexity: O(1), no extra space used

// Did this code successfully run on Leetcode : Q:162
// Any problem you faced while coding this :

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        if(nums.length == 1){
            return 0; // return index
        }
        // If we find some condition to divide an array in two half using some condition and perform search
        // than we can use binary search there

        // A peak element is an element that is strictly greater than its neighbors.
        // nums[i] != nums[i+1]
        //         0, 1, 2, 3, 4, 5, 6 <- Index
        // Idea:  [1, 2, 1, 3, 5, 6, 4]
        //         L        M        H
        // compare mid with left and right element, as right is greater than mid, so if we move right chances are more to find peak element than moving left
        // L = M + 1;

        int low = 0;
        int high = nums.length -1;
        int n = nums.length;
        // int mid = -1;

        while(high >= low) {
            int mid = low + (high-low)/2; // to avoid integer overflow

            // check if mid is the peak element
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])){
                return mid;
            } else if(mid != 0 && nums[mid] < nums[mid-1]){
                // chances are we will find peak on the left side, as left neighbour is greater
                high = mid - 1;
            } else {
                // move to right as right is greater
                low = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
