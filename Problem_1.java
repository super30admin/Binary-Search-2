// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We apply 2 rounds of binary search in this case. To find the index we run search from 0 to n - 1. If on finding the target
   nums[mid] > nums[mid - 1], we know this is the first index. Else we have to search to left so end = mid - 1. Now we run another
   round of search from firstIndex to n - 1. If on finding the target nums[mid] < nums[mid + 1], we know this is the last index. Else
   we have to search to right so start = mid + 1.
*/

class Solution {

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1])
                    return mid;
                else
                    end = mid - 1;
            } else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public int findLast(int[] nums, int start, int target) {
        int n = nums.length;
        int end = n - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                if(mid == n - 1 || nums[mid] < nums[mid + 1])
                    return mid;
                else   
                    start = mid + 1;
            } else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;

    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int n = nums.length;

        if(nums[0] > target || nums[n - 1] < target)
            return new int[]{-1, -1};
        
        int first = findFirst(nums, target);

        if(first == -1)
            return new int[]{-1, -1};

        int last = findLast(nums, first, target);

        return new int[] {first, last};
    }
}