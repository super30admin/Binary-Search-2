//Time Complexity : O(logn)
//Space Complexity: O(1)
//Did it run on LeetCode: Yes
//Any issues: No


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        if (low != nums.length -1 && nums[low] > nums[low +1]){
            return low;
        }
        else if (high != 0 && nums[high] > nums[high -1]){
            return high;
        }
        for (int i = 1; i<nums.length ; i++){
            if (nums[i]<nums[i+1]){
                continue;
            }
            else{
                return i;
            }
        }
        return high;
    }
}
