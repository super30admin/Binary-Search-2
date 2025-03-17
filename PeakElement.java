// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We calculate mid first and see if that element is peak or not. In case its not a peak, we try to go towards
the half which has next greater value, hence we try to climb towards the peak
In case both left and right values are greater, we select the right side value
* */

class PeakElement {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right = nums.length - 1;
        while(left<=right)
        {
            int mid=left + (right - left)/2;
            if((mid==0 || nums[mid]>nums[mid - 1]) && (mid==nums.length - 1 || nums[mid]>nums[mid + 1]))
                return mid;
            else if(nums[mid]<nums[mid + 1])
            {
                left=mid + 1;
            }
            else
            {
                right = mid -1;
            }
        }
        return -1;
    }
}