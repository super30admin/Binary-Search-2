/* Time complexity: O(log n) */

/* All the test cases passed on leetcode */

/* 
Approach: 
 1. Using binary search algorithm, create the two pointers left - first index of the array
 and right pointer - last index of the array, with the help of these pointers find the middle element
 2. If the element at middle index is greater than the element at mid + 1 index then the minimum value
 exists at mid + 1 index, so return mid + 1
 3. If the element at mid index is smaller than the element at mid - 1 index then the minimum value  
 exists at the mid index therefore return the mid index
 4. If none of the condition satisfied then check if the mid element is greater the element at index 0, 
 then that means the minimum element exists on the right side of the mid index, if this condition does not
 satisfy that means the minimum element exists at the left side of the mid element
 5. Repeat this process until one of the condition is satisfied or when left and right pointers 
 are pointing to the same element

*/

class MinInRotatedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        if(n == 1) return nums[0];
        if(nums[right] > nums[0]) return nums[0];
        
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] > nums[0]) {
                left = mid + 1;
            }
            else {
                right  = mid  - 1;
            }
        }
        return  -1;
    }
}