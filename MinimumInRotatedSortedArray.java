class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int mid =0;
        int n = nums.length-1;
        while(low <= high){
            if(low == high)
                return nums[low];
            if(nums[low] < nums[high])
                return nums[low];
            mid = low+(high-low)/2;
            if((mid == 0 || nums[mid-1] > nums[mid]) &&  (mid == n || nums[mid+1] > nums[mid])){
                return nums[mid];
            }
            else if(nums[mid] < nums[high])
            high = mid - 1;
            else
            low = mid +1;
    }
    return -1;
    }
}