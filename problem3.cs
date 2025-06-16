public class Solution {
    public int FindPeakElement(int[] nums) {
        int left=0;
        int right = nums.Length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if((mid == nums.Length-1 || nums[mid]>nums[mid+1])&&(mid ==0 ||nums[mid]>nums[mid-1]))
            {
                return mid;
            }
            else if(nums[mid+1]>nums[mid])
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