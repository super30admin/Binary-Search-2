// Time Complexity : O(logn) --> Search space is reduced to half
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
//One part from the middle will be sorted and other will be unsorted
//The minimum element will always lie in the unsorted part --> By observation
//So we keep moving towards the unsorted arrayalso checked 4.5.6.8.9.0.1.2 case where
//when we move towards right and have low as 0 after second middle if the number at low is less than the number at high then the low element is the lowest

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int mid;

        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if((nums[mid]<nums[mid + 1]) && (nums[mid]<nums[mid-1])){
//          if((mid == n-1 || nums[mid]<nums[mid + 1]) && (mid == 0 || nums[mid]<nums[mid-1]))
//                mid == n-1 is not required as the check (is num at low less than that at high) deals with it
//                mid == 0 check is reqd for example cases like [2,1] but if we check mid=1 first the if is stopped there only
                return nums[mid];
            }else if(nums[mid]>=nums[low]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}