// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem3 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                high = mid - 1;
            }
            else if((mid == n-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1])){
                return mid;
            }else{
                low = mid + 1;
            }
        }
        return 888;
    }
}