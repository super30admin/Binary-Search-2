//. Find Minimum in Rotated Sorted Array
//Time Complexity:O(logn)
//Space Complexity:O(1)
class Solution1 {
    public int findMin(int[] nums) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        if(nums==null || nums.length==0)
        {
            return -1;
        }

        while(low<=high)
        {
            if(nums[low]<=nums[high])//chk at start
            {
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==n-1 || nums[mid]<nums[mid+1]))
            {
                return nums[mid];//as min in rotated array
            }
            //chk if left array is sorted
            else if(nums[low]<=nums[mid])
            {
                //min to right side
                low=mid+1;
            }
            else
            //right array is sorted
            {
                high=mid-1;
            }
        }
        return -1;
    }
}