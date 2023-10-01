// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FirstLastPositionofElement {
    class Solution {
        private int binarySearchFirst(int[] nums, int low, int high, int target){

            while(low <= high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid] > nums[mid-1]){
                        return mid;
                    }
                    else{
                        high = mid-1;
                    }
                }
                else if(nums[mid] < target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            return -1;
        }

        private int binarySearchLast(int[] nums, int low, int high, int target){

            while(low <= high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                        return mid;
                    }
                    else{
                        low = mid+1;
                    }
                }
                else if(nums[mid] < target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            int low= 0, high = n-1;
            if(n == 0){
                return new int[]{-1,-1};
            }
            if(nums[0] > target && nums[n-1] < target){
                return new int[]{-1, -1};
            }

            int first = binarySearchFirst(nums, low, high, target);
            if(first == -1){
                return new int[]{-1, -1};
            }
            int last = binarySearchLast(nums, first, high, target);

            return new int[]{first, last};
        }
    }
}
