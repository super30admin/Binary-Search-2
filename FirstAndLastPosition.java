/* Time complexity : O(log n) */

/* All test cases passed on leetcode */

/* 
Approach:
    Using binary search algorithm, find the first and last index of the target element
     1. Create the findLimit method which takes the given array, target and boolean value
     that specifies if the poisition is first or last
     2. Create the two pointers pointing to the first and last index of the array
     3. Find the mid element, find the first position of the target element. To find the first 
     position of the target element make the boolean flag to true
     4. If the mid element is equal to target element and if the mid index is equal to the low/left pointer or
     if the mid - 1 element is not equal to the target element then no target element exists before the 
     mid element so, return the mid index, if this condition is not true then the first index lies on the 
     left side of the mid index therefore make the high/right pointer equal to mid - 1
     5. Process will repeat until the first index is returned
     6. Call the findLimit method again with the boolean flag false to find the last position
     7. Find the mid element, if mid element is equal to the target element then, check if the mid index 
     is equal to the right/high index or if the mid + 1 element is not equal to target, if one of the conditions
     is true then the last position will be the mid position 
     8. Therefore the first and last position of target element can be found using binary search 
*/

class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = this.findLimit(nums, target, true);
        int last = this.findLimit(nums, target, false);
        if(first == -1) return new int[]{ -1, -1};
        return new int[]{first, last};
    }
    private int findLimit(int[] nums, int target, boolean first){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
               if(first) {
                   if(mid == low ||  nums[mid  - 1] != target) {
                       return mid;
                   }
                   else {
                       high = mid  - 1;
                   }
               }
             else{
                 if(mid == high || nums[ mid + 1] != target){
                     return mid;
                 }
                 else {
                     low = mid + 1;
                 }
             } 
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }  
        }
        return -1;
        
    }
}