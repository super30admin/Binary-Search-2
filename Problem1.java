/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN)
* 
* Space Complexity: O(1)
Approach:

1. completed sorted array --- first element is the minimum
2. for the minimum, neighours of that elememt should be greater.
3. we need to search an element to the sorted half the move to the unsorted half 

 */
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while(low <= high)
        {
            if(nums[low] <= nums[high]) 
            {
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])) return nums[mid];
              //we will check which side side is sorted
              //if left side is sorted then our element is in right side 
             else if(nums[low] <= nums[mid])
             {
                 low = mid + 1;  
             }
             else  //if right side is sorted the our element lies in left side.
             {
                    high = mid - 1;
             }
        }

        return -1;

    }
}