// Time Complexity : O(logN)
// Space Complexity : O(1) -- not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Had to brainstorm about the logic


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        int[] result = {-1,-1}; 
        while(left<=right){

            int mid = left + (right - left)/2;
            if(target == nums[mid]){

                int i = mid;
                int j = mid;
                while(i>=left){
                    if(nums[i]==target){
                        result[0] = i;
                    }
                    i--;
                }
            
                while(j<=right){
                    if(nums[j]==target){
                        result[1] = j;
                    }
                    j++;
                }

                return result;          
            } else if(target < nums[mid]){
                right = mid - 1;
            } else if(target > nums[mid]){
                left = mid + 1;
            }
        }

        return result;

    }
}