// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Take minimum as first element and update it if any element is less than it
 * 
 */
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Do Binary search and find min when it is less than both prev element and next element
 * 
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            // initialize mid
            int mid = low + (high - low)/2;
            // if entire array is sorted return element at low
            if(nums[low] <= nums[high])
                return nums[low];
            // if mid is first or less than prev element and mid is at end or mid is less than next lement return that element at mid
            else if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1]))
                return nums[mid];
            // if left array is sorted
            else if (nums[low] <= nums[mid])
                low = mid + 1;
            // if right array is sorted
            else if(nums[mid] <= nums[high])
                high = mid - 1;
        }
        // if element is not found
        return -1;
    }
}


