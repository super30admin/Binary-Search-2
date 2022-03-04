// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class SolutionBSMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid+1 <= nums.length-1 && nums[mid]>nums[mid+1]) return nums[mid+1];
            else{
                if(nums[mid]<nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        
        return nums[0];
    }
}
