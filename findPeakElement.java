// 162. Find Peak Element

// Time Complexity : O(log n)
// Space Complexity : O(1) since we only used pointers 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// [1,2,1,3,5,6,4]
// peaks:
// - 2 -> [1,2,1]
// - 6 -> [5,6,4]
// to find a peak, if you keep going higher and higher then you will reach the peak somehow
// so start with finding mid - check which side is greater than mid
// move towards that side 
// return when mid is greater than both side neighbours 

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(nums[mid+1] > nums[mid]){
                low=mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}