// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

//if mid element is greater than the previous element and the next element, then it
//is the peak element. If we find greater element to the left of the mid element, perform
//binary search on the left side, else do binary search on the right side.

class PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        if(nums.length == 1) return 0;


        int low = 0 ;
        int high = nums.length -1;
        int max = -1;
        if(nums[0] > nums[1]) return 0;
        if(nums[high-1] < nums[high]) return high;
        low = 1;
        high = high - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if( nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]){
                return mid;
            }
            else if(nums[mid-1] > nums[mid]){
                high = mid-1;
            } else if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }
        }
        return -1;

    }
}