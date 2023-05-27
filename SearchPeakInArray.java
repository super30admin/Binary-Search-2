// Time Complexity : O(logN)
// Space Complexity : O(1) -- not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to brainstorm about the logic


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // int mid = left + (right-left)/2;
        if(nums.length==1){
            return 0; //0th index is ans
        }
        if(nums[left]>nums[left+1]){
            return left;
        }
        if(nums[right]>nums[right-1]){
            return right;
        }
        left++;
        right--;
        while(left<=right){
            if(nums[left]>nums[left-1] && nums[left]>nums[left+1]){
                return left;
            } else{
                left++;
            }
            if(nums[right]>nums[right-1] && nums[right]>nums[right+1]){
                return right;
            } else{
                right--;
            }
        }
        
        return 0;
    }
}

//OR

// class Solution {
//     public int findPeakElement(int[] nums) {
//         int start = 0;
//         int end = nums.length-1;
//         while(start < end){
//             int mid = start + (end - start)/2;
//             if(nums[mid] > nums[mid+1]){
//                 end = mid;
//             }
//             else{
//                 start = mid+1;
//             }
//         }   
//         return start;
//     }
// }