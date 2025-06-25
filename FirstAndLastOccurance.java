
// Time Complexity : O(log n) while we are doing two separate binary searches, the Big-O annotation boils down to O(Logn)
// Space Complexity : O(1) no additional space is required
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None


//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //we perform binary search on this.
        //low is at 0 and high at the end.
        //we check if the mid is our target, if it less we move right less left
        //once the target is identified we check if the value is equal to the target.
        //but what after that, how do we decide which side to move?

        //to tackle this challenge, we do two different binary search,
        //one to get the start index of the target which would be at the left side
        //one to get the end index of the target which would be at the right side
        
        //so the average T.C. would be O(log n)

        //basecase
        if (nums == null || nums.length == 0){
            return new int [] {-1, -1};
        }

        //get the first index
        int first = binarySearchFirst(nums, target);

        if(first == -1){
            return new int[] {-1, -1};
        }

        int second = binarySearchLast(nums, target);

        return new int[] {first, second};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                if(mid == low || nums[mid-1] != nums[mid]){
                    return mid;
                }
                high = mid - 1;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target){
        int low = 0;
        // int n = ;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                if((mid == high) || (nums[mid+1] != nums[mid])){
                    return mid;
                }
                low = mid + 1;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}