
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] pos = new int[2];
        
        pos[0] = -1;
        pos[1] = -1;
        
        int low = 0;
        int high = nums.length-1;
        
        // first occurrence
        pos[0] = bs(low, high, nums, target, true);

        // last occurrence
        pos[1] = bs(low, high, nums, target, false);
        
        return pos;
        
    }
    
    public int bs(int low, int high, int[] nums, int target, boolean first) {
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                res = mid; 
                if(first) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return res;
    }
}
