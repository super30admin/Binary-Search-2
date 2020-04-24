// Time Complexity : O(log n) since we are doing binary search recursively
// Space Complexity : O(log n) number of recursive calls
// Did this code successfully run on Leetcode : Partially
// Any problem you faced while coding this : Faling for some cases. There are different possibilities once I search the required element.
/* The previous element can be equal or the next can be equal or both the prev and next can be equal to search element. Challenge was to 
consider all the possibilities. 
Algorithm:  Find the mid element recursively to land up on the searched element. Then do a binary search recursively at the left and binary search
recrusively at the right to get left and right. Left will give start position and right will give end position. If both return -1, implies
mid is either the start or end position.
*/
class Solution {
    int[] result = new int[2];
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        BinarySearch(nums, start, end,target);
        if(result == null){                                     // element not found
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
    
    public int BinarySearch(int[] nums, int start, int end, int target) {       
        if(end < start){
         return -1;                             // base condition
        }
        int mid = (start+ (end))/2;
        if(nums[mid] == target){            // Once the element is found.
           int left =  BinarySearch(nums, start, mid-1, target);                // Do BS on the left 
           int right = BinarySearch(nums, mid+1, end, target);      // Do BS on the right
           if(left == -1 && right != -1){               // If no more occurances of the element on left, then mid is start and right is end
           result[0] = mid;
           result[1] = right;
           } else 
           if(left != -1 && right == -1){       // If no more occurances of the element on right, then mid is end and right is start
           result[0] = left;
           result[1] = mid;
           } else 
           if(left == -1 && right == -1){    // If no more occurances of the element on left and right implies a single occurance
           result[0] = mid;
           result[1] = mid;
           }  
        }
    else 
    if(nums[mid] > target){
            return BinarySearch(nums, start, mid-1, target);
        }
    else
    {       
            return BinarySearch(nums, mid+1, end, target);
    }
        return mid;
    }
}