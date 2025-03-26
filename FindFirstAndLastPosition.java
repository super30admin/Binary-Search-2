/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int second = findSecond(nums, target);
        return new int[]{first, second};
    }
        public int findFirst(int[] nums, int target){
            int low =0;
            int high = nums.length -1;
            int index = -1;
            while(low <= high){
                int mid = low +(high -low)/2;
                if(nums[mid] == target)
                {
                    index = mid;
                    high = mid -1; // Left part of the Array
                }
                else if(nums[mid] < target)
                    low = mid +1;
                else
                    high = mid-1;
            }
        return index;
        }

        public int findSecond(int[] nums, int target){
            int low =0; int high =nums.length -1;
            int index = -1;
            while(low <= high){
                int mid = low +(high - low)/2;
                if(nums[mid] == target){
                    index = mid;
                    low = mid+1; // Right part of the Array
                }
                else if(nums[mid] > target){ // if nums[Mid] is greater than target, move high to mid
                    high = mid-1;
                }
                else
                {
                    low = mid +1;
                }

            }
            return index;
        }
}
