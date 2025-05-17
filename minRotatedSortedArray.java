//check which part of the array is sorted and eliminate that part as the min element will be in the other part. 
//Time complexity: O(log n)
class Solution {
    public int findMin(int[] nums) {
        int low=0; 
        int high= nums.length-1;
        while(low<=high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low) / 2;
            if(mid != 0 && nums[mid] < nums [mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}