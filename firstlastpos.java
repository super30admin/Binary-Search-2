// Time complexity : O(logn)
// Space complexity: O(1)
class Solution {

    public int firstBinary(int nums[], int target){
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low+ (high - low)/2;

            if(nums[mid] == target){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }
                else {
                    high = mid -1;
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
       
    private int lastBinary(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid == target){
                if(nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            } 
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
        {
            return new int[] {-1,-1};
        }
        int n = nums.length;
        
        int first = firstBinary(nums, target);

        int last = lastBinary(nums, first, n, target);

        return new int[]{first, last};
    }

