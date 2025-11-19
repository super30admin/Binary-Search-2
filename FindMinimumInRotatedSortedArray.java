// time: O(log N)
// space: O(1)
// leetcode ran? - yes
// problem faced - i pput this check if(nums[left] <= nums[right]) outside the while
// but when i saw solution, it needs to be in the while loop and also i missed out 
// edge cases of mid == 0 and mid == nums.length - 1 in if((mid == 0 || nums[mid - 1] > nums[mid]) && 
// (mid == nums.length - 1 || nums[mid] < nums[mid+1]))

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            // all accending order - so we found low value
            if(nums[left] <= nums[right])
            {
                return nums[left];
            }
            int mid = left +(right - left)/2;
            // if we find the low with this condition
            if((mid == 0 || nums[mid - 1] > nums[mid]) && 
            (mid == nums.length - 1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            // left sorted array - so low is on right side
            if(nums[left] <= nums[mid])
            {
                left = mid + 1;
            }
            else // else low is on left
            {
                right = mid - 1;
            }
        }

        return -1; // should not reach
    }
}