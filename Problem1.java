class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Initializing lo, hi
        int lo = 0, hi = nums.length - 1;
        // Initializing output variable
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(lo <= hi){
            int mid = lo + (hi -lo)/2;
            //check if mid is equal to target, then run two while loop until we get left and right most index
            if(nums[mid] == target){
                int left = mid, right = mid;
                while(left > 0 && nums[left - 1]==nums[left]){
                    left--;
                }
                while(right<nums.length - 1 && nums[right + 1] == nums[right]){
                    right++;
                }
                res[0]= left;
                res[1]= right;
                return res;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return res;
        
    }
}