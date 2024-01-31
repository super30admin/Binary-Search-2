class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
        return -1;
        int size=nums.length;
        int low=0;
        int high=size-1;
        int mid;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            return nums[low];
            mid=low+(high-low)/2;
            if((mid==0||nums[mid]<nums[mid-1])&&(mid==size-1||nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;

            }
            else
            {
                high=mid-1;
            }

        }
        return 949422;
    }
}