
// The idea behind this approch is that the minumum always stays in the unsorted part of the rotated array
// So we try to exclude sorted part of the array and compare the mid with its neighbours in the unsorted part
// to find the minumum

//Time Complexity - O(logn)
//Space Complexity - O(1)

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            // Verify if the entire array is sorted
            if (nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low)/2;

            // Compare the element in mid with its neighbours to find the minimum
            if ((mid == low || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            // Check for left sorted array
            else if (nums[low] <= nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}