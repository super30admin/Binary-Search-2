// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: We treat this as two different problems to find left index and right index. For the left we check if the mid element is target and 
//if it is greater than the prev element than if the leftmost index. if not we keep moving left. if the mid is greater than the target than we shift
//the range to the left. Repeat the same for the right index.
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int low= 0;
        int high = nums.length -1;
        if (nums == null || nums.length == 0)return new int[] {-1,-1};
        if(nums[0] > target || nums[high] < target) return new int[] {-1,-1};
        int left = LeftSearch(nums, low,high,target);
        int right = RightSearch(nums,low,high,target);
        return new int[] {left,right};
    }

    public int LeftSearch(int[] nums, int low,int high, int target){
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if (nums[mid]> target) {
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public int RightSearch(int[] nums, int low,int high, int target){
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid+1]) {
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}