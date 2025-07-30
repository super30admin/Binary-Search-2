class Solution {
    public int findPeakElement(int[] nums) {
        // move toward the increasing side

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        while( l<= r ){
            mid = l + (r-l)/2;
            if( (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid-1]) ){
                return mid;
            }
            else if( nums[mid] < nums[mid + 1] ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return mid;

    }
}
