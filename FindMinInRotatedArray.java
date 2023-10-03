// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Missed to handle Array index out of bounce but later realized and fixed 
class Solution {
    public int findMin(int[] nums) {

       
        int n=nums.length;
         int low=0; int high=n-1;
        if(nums==null || nums.length==0)return 12345;

        while(low<=high){
        if(nums[low]<=nums[high]){
            return nums[low];
            }
            else{
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1])
             && (mid==n-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
            }
            
    }
    return 123465;
    }
}