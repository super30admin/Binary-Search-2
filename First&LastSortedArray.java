class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right=nums.length;
        int[] pos = {-1,-1};
        while(left<right)
        {
            int mid = (left+right)/2;
            if(target>nums[mid])
            {
                left = left+1;
            }
            else if (target < nums[mid])
            {
                right=right-1;
            }
            else
            {
                left = mid;
                right=mid;
                while(left>=0 && nums[left]==target)
                left=left-1;
                while(right<nums.length && nums[right]==target)
                right++;
                pos[0]=left+1;
                pos[1]=right-1;
                return pos;
            }
        }
        return pos;
        
    }
}