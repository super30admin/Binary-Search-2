//Time Complexity:O(logn)
//Space Complexity:O(1)
//Did it run on Leetcode: Yes
//Any issues: The program compiled and executed successfully; All the visible test cases have passes; Although, for the hidden test cases, there was a time exceed alert



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        if (nums == null || nums.length == 0){
            return arr;
        }
        int low = 0;
        int high = nums.length -1;
        
        while (low <= high ){
            int mid = low + (high - low)/2;
            if (nums[mid] == target){ 
                if (nums.length == 1){
                    arr[0] = 0;
                    arr[1] = 0;
                    return arr; 
                }

                low = mid;
                high = mid;
                while (nums[low]==nums[mid] || nums[high]==nums[mid]){
                if (nums[low] == nums[mid] && low != 0){
                low = low - 1;
                } 
                if (nums[high] == nums[mid] && high != nums.length-1){
                high = high + 1;
                } 
                
            
        }
                arr[0] = low+1;
                arr[1] = high-1;
                return arr;
                }
            else if (nums[low] <= nums[mid]){
                if (nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (nums[mid]<= target && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return arr;
    }
   
}
