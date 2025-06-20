// Time Complexity : O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMinElement {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n -1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}