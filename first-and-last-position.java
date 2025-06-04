//T.C: O(logn) n: length of nums[]
//S.c: O(1) 

/*Approach: I will perform two binary search one to find the First positon and the other to find the last position of the target.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) return new int[]{-1,-1};
        if(nums.length == 1 && nums[0] == target) return new int[]{0, 0}; 
        int first = leftMostElement(-1, nums.length, nums, target);
        int last = rightMostElement(-1, nums.length, nums, target);

        return new int[] {first, last};
    }


    private int leftMostElement(int low, int high, int[] nums, int target){
        while(high - low > 1){
            int mid = low + (high - low)/2;

            if((mid == low && mid >= 0 ) || nums[mid] < target) low = mid;
            else{
                if( nums[mid] == target && nums[mid - 1] < target) return mid;
                else high =  mid;
            }
        }
     return -1;
    }

     private int rightMostElement(int low, int high, int[] nums, int target){
            while(high - low > 1){
            int mid = low + (high - low)/2;

            if(nums[mid] < target) low = mid;
            else{
                if((mid == high && mid < nums.length) || nums[mid] == target && nums[mid + 1] > target) return mid;
                else high =  mid;
            }
        }
     return -1;
    }
}