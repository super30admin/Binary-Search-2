// time : O(log N)
// space: O(1)
// leetcode ran? - yes
// problems ffaced - i did not know this check - else if(mid > 0 && nums[mid - 1] > nums[mid]) 
// i undestand now that its there coz we can have possible peaks on left if this is true
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            // mid can be the peak
            if((mid == 0 || nums[mid] > nums[mid - 1]) && 
            (mid == nums.length - 1 || nums[mid] > nums[mid+1]))
            {
                return mid;
            }
            else if(mid > 0 && nums[mid - 1] > nums[mid]) // possible peak of left side
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return -1; // not reachable
    }
}