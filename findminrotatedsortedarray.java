//Time Complexity: O(logn)
//Space Complexity:
/* Approach:
As it is a rotated sorted array. We move to the unsorted part of the array to find min. min will be always minimum than it's left side. 
*/
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high =  nums.length -1;
        while (low <= high){
            //check if complete array is sorted
            if(nums[low]<=nums[high]) return nums[low];
            int mid = low + (high -low)/2;
            //check if mid is min
            if (mid > 0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if (nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                //left sorted
                high = mid - 1;
            }
            }
            return 799;
        }
    }