class Solution {
    public int findPeakElement(int[] nums) {
        // if length = 1, then output = 0;
        if(nums.length == 1){
            return 0;
        }
        //if length = 2, then ouptut is minimum out of 2
        if(nums.length == 2){
            if(nums[0]<nums[1])
                return 1;
            else
                return 0;
        }
        // initializing lo, hi
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            // finding mid
            int mid  = lo + (hi - lo)/2;
            
            // check if mid is greater than mid + 1
            if(nums[mid] > nums[mid + 1]){
                hi = mid;
            }
            else
                lo = mid + 1;
        }
        return lo;
    }
}