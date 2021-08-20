class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        else{
            return binarySearch(nums,0,nums.length-1);
        }

    }
    public int binarySearch (int[] nums, int l, int r){

        int mid;
        int min = 5001;
        while(l<=r){
            mid = l + (r-l) /2;

            if (nums[l] <= nums[mid]){
                min= Math.min(nums[l],min);
                l = mid+1;

            }
            else {
                min = Math.min(nums[mid],min);
                r = mid-1;
            }
        }
        return min;
    }
}