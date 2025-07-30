class Solution {
    public int findMin(int[] nums) {
        // min is on non sorted side


        int left = 0;
        int right = nums.length - 1;

        int mid = 0;

        while( left <= right){
            mid = left + (right - left)/2;


            if( (mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1]) ){
                return nums[mid];
            }
            else if( nums[right] <= nums[mid] ){ // it means right not sorted
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }


        }
        return 0;
    }
}
