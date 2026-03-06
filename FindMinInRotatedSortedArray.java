// TimeComplexity: O(logn)
// SpaceComplexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid =-1;
        if(nums[0] <= nums[n-1]) {
            return nums[0];
        }
        while(low<=high) {
            mid = low+(high-low)/2;
            if ((mid == 0 ||nums[mid]< nums[mid-1]) && (mid ==n-1 || nums[mid]<nums[mid+1])) {
                return nums[mid];
            } 
            if(nums[mid]>nums[high]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        } 
        return 456;      
    }
}
