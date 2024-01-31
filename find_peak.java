class Solution {
    public int findPeakElement(int[] nums) {
        int size=nums.length;
        int low=0;
        int high=size-1;
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1])&&(mid==size-1||nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid!=0&&nums[mid-1]>nums[mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return 949422;
        
    }
}