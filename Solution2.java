// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// I check if the array is left sorted or right sorted. If the entirety of the array is sorted, I return the element at first index. If not, I return element at mid index if mid equals 0 or element at mid index is less than element at mid -1 index and mid is the last index or element at mid is less than element at mid+1 index.
// If that is not the case, move low to mid+1 if the array is left sorted, or high to mid-1 if the array is right sorted.
class Solution2 {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[low]<nums[high])
            {
                return nums[low];
            }
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}