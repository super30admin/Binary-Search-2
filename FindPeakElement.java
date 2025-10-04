// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element/description/

/**
 * Time Complexity :  log(n) since we reduce search space by half by checking largest number of mid
 * Space Complexity : O(1) since no extra linear space
 * 
 */

/**
 * This problem can be solved by using binary search even if the array is not sorted.
 * Because of the condition that no 2 adjacent elements are same
 * Hence, when we apply binary search and move towards larger element, we are bound to get atleast one peak
 */

class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while(low <= high){

            int mid = (low + (high - low) / 2);

            // if mid is greater than neighbours or if mid is at edges and greater then it's previous & next element return mid
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) { 
                return mid;
            }else {  // if not, then move towards greater neighbour
                if(mid > 0 && nums[mid - 1] > nums[mid]){ // check bounds
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }

        return nums[low];
    }
}