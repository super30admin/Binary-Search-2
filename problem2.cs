public class Solution {
    public int FindMin(int[] nums) {
        int left=0;
        int right = nums.Length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[left]<=nums[right])
            {
                return nums[left];
            }
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid== nums.Length-1 ||nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[left]<=nums[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return nums[left];
        
    }
}