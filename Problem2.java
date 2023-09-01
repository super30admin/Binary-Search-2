// Time Complexity : O(log n)
// Space Complexity : O(1) constance space to store min element;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No this came straightforward

public class Problem2 {
    public int findMin(int[] nums) {
        //writing the base case
        if(nums == null || nums.length == 0) return -1;

        //declare the low and high
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;
            min = Math.min(min, nums[mid]); //check which number is smaller between nums[mid] and current min
            if(nums[low] < nums[mid]){ //right side is sorted
                if(min <= nums[low]){ //min cannot be on this side as low is the lowest integer on this sorted side of array so search on left
                    low = mid + 1;
                }else{
                    min = Math.min(min, nums[low]);
                }
            }else{
                if(min <= nums[high]){
                    high = mid - 1;
                }else{
                    min = Math.min(min, nums[mid + 1]);
                }
            }
        }

        return min;

    }
}
