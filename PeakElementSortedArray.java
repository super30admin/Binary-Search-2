//Time Complexity: O(logn)
//Space Complexity: O(1)
/* Approach:
Use ebinary search to find mid.Compare the mid with it neighbors. if it is peak return mid
else, adjust high and low pointers to do a binary search where the elements are greater
If a peak is found, its index is returned; otherwise, -1 is returned if no peak exists in the array.*/


class PeakElementSortedArray {
    public int findPeakElement(int[] nums) {
        int low = 0 ;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if ((mid == 0 || (nums[mid]>nums[mid -1 ])) && (mid == nums.length -1 || (nums[mid]> nums[mid+1]))){
                return mid;
            }
            else if( mid != 0 && nums[mid - 1] > nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
            return -1;
    }
}