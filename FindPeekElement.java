// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
Keep comparing mid's value with its next element and slide the right point to mid if its greater or else left = mid+1;
peak element would be in left variable;
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){

            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;

            }
            else {
                left=mid+1;
            }
        }

        return left;
    }
}