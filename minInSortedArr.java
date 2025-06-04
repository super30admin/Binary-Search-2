//T.C: O(logn) n: length of nums[]
//S.c: O(1) No extra data structure is used except few variables to store my pointers which is constant.

/*Approach: I will just find the pivot element and return the value.Perform binary search on the nums[] to find the pivot element.
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int pivot = findPivot(-1, nums.length, nums);
        
        return nums[pivot];
    }



    private int findPivot(int low, int high, int[] nums){
        while(high - low > 1){
            int mid = low + (high - low)/2;

            if(nums[mid] >= nums[0]) low = mid;
            else high = mid;
        }
     return high%nums.length;
    }
}