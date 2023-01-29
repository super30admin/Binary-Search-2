class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high= nums.length-1;
        int mid=0;


        while(low<=high)
        {
            mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1] )&&( mid==high|| nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid>0 && nums[mid]<nums[mid-1])
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        } return -1;
    }
}