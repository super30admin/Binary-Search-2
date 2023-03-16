class Solution {
    public int findPeakElement(int[] nums) {
        

        int l = nums.length;
        int low = 0 ;
        int high = l-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid==high) return mid;
            else if(mid==0 && nums[mid+1]<nums[mid]) return mid;
            else if(mid==0 && nums[mid+1]>nums[mid]) return mid+1;
            else if(nums[mid-1]<nums[mid] 
                    && nums[mid]> nums[mid+1]) return mid;
            else if(nums[mid-1]>nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}