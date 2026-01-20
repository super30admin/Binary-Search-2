class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;

        int low=0, high=n-1;

        while(low<high)
        {
            if(nums[low]<=nums[high]) return nums[low];
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high])
            {
                low=mid+1;
            }

            else
            {
                high=mid;
            }



        }

        return nums[low];
    }
}