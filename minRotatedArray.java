class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l+(r-l)/2;
        int min = 5001;
        while(l<=r)
        {
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid== nums.length - 1 || nums[mid]<nums[mid+1]))
                return nums[mid];
            else if(nums[r] < nums[mid])
            {
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
            mid = l+(r-l)/2;
        }
        return -1;
    }
}