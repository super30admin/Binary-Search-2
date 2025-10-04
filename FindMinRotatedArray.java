// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/


// Time Complexity :  O(n) since we reject sorted half everytime, reducing search space by half.
// Space Complexity : O(1) since no extra linear space


/**
 * Here the important thing is, if the range is rotated, minimum would never lie in sorted side. 
 * Hence we reject sorted side and move towrds unsorted side.
 */


class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while(low <= high){

            if(nums[low] <= nums[high]){  // if array/range is sorted already, 1st element is the lowest
                return nums[low];
            }

            int mid = (low + (high - low) / 2); 

            if(mid > 0 && nums[mid] < nums[mid - 1] &&         // if nums[mid] is smaller than both it's neighbours, it is the minimum element. 
               mid < n - 1 && nums[mid] < nums[mid + 1] ){     // checks added for bounds mid > 0 && mid < n - 1
                return nums[mid];
            }

            if(nums[low] <= nums[mid]){   // if we are in sorted range
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return 5001; // since max element is 5000
    } 
}