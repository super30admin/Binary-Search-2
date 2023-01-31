// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use binary search here. If nums[start] < nums[end], the array we are looking at is sorted and we return nums[start]. On calculating
   mid, if we see nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1], we return mid. Since the min element will never be in sorted 
   part, if we see nums[start] < nums[mid], we move start = mid + 1, else end = mid - 1.
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int n = nums.length;
        if(nums[0] < nums[n - 1])
            return nums[0];
        
        int start = 0, end = n - 1;

        while(start <= end) {
            if(nums[start] < nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid] < nums[mid -1]) && (mid == n - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if(nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}