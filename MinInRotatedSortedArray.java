// Min is always in the unsorted part of the array since it a Rotated sorted array
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low < high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = (high-low)/2+ low;
            if((mid == 0 ||nums[mid] < nums[mid-1]) && nums[mid] < nums[mid+1]) {
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]) {low=mid+1;} // left sorted
            else {high = mid -1;} //right sorted
        }
        return nums[high]; // return -1;
    }
}