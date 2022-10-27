//Time complexity is O(log n)
//Space complexity is O(1)
//able to submit code in leetcode
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = helper(nums, target);
        if(i==-1)
        {
            return new int[]{-1, -1};
        }
        int j = i+1;
        while(i>=0 && nums[i]==target){
            i = i-1;
        }
        while(j<nums.length && nums[j]==target){
            j = j+1;
        }
        return new int[]{i+1, j-1};
    }
    public int helper(int[] nums, int target){
        int l=0;
        int r = nums.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else
            {
                r= m-1;
            }
        }
        return -1;
    }
}
