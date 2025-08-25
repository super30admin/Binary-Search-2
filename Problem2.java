//Time Complexity - O(log n)
//Space Complexity - O(1)
//Did it run on leetcode - yes

//Your approach
/*
Use binary search to find pivot point where rotation occured
if array from low to high is sorted return element at low index
perform binary search on left and right subarray
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low<=high) {
            int mid = low + (high - low)/2;
            if (nums[low] <= nums[high]) return nums[low]; //found minimun at low index
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == high || 
            nums[mid]<nums[mid+1])) {
                return nums[mid];
            } else if(nums[low]<=nums[mid]) {
                low = mid + 1; //left array is sorted
            } else {
                high = mid - 1; //right array is sorted
            }
        }
        return -1;
        
    }
}
