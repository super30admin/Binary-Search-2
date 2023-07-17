//Find Peak Element
//Time Complexity:O(logn)
//Space Complexity:O(1)
class Solution2 {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if((mid==0 || nums[mid]>nums[mid-1]) &&(mid==n-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid>0 && nums[mid]<nums[mid-1])//peak can be at left
            {
                high=mid-1;
            }
            else//peak at right
            {
                low=mid+1;
            }
        }
        return -1;
    }
}