// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// I'm using binary search here. At each step I check if mid is already a peak.
// If it's not, I look at which side is going "uphill". If the right neighbor is bigger,
// I move right, because if I keep climbing I'll either hit a peak or reach the end
// Same idea for the left side. This way I don't need to scan the whole array.

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high =nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid-1 ==-1 || nums[mid]>nums[mid-1]) && ( mid+1 ==nums.length|| nums[mid]>nums[mid+1])){
                return mid;
            }
            if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        
    }
}
