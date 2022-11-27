class Solution {
    public int findMin(int[] nums) {
        // Brute Force
//         for(int i = 0; i<nums.length; i++){
//             if(i == nums.length-1) return nums[i];
//             if(nums[i] < nums[nums.length - 1]){
//                 return nums[i];
//             }
           
           
            
//             else if((i > 0 && nums[i] < nums[i - 1] ) && (i == nums.length-1 ||nums[i] < nums[i + 1])){
//                 return nums[i];           
//             }
//         }
//         return -1;
        
        
        
        
        // Binary Search
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]) return nums[low];
            if((mid ==0 || nums[mid] < nums[mid - 1]) && (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}



// Time Complexity : O(logn)
// Space Complexity : O(1), bcz no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
// Your code here along with comments explaining your approach
// Here we need to find the minimum in a rotated sorted array. In a rotated sorted array every time the half array will be sorted. If we can find the sorted array. The minimum element should be in the unsorted array.
// Edge Cases: The minimum can be the first index. So we need to check low < high then we can return low as minimum. checking whether mid==0 becz mid - 1 should not go outof bound error. Same with nums.length -1 number.
