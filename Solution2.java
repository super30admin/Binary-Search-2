/* 
Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Time Complexity: O(log n)

Space Complexity: O(1)

Use binary search to locate the minimum by comparing the middle element with its neighbors and the search boundaries.
If the current low-to-high range is already sorted, the element at low is the minimum.
Otherwise, move left when the middle belongs to the rotated half or move right when the middle is in the sorted half.

*/ 

class Solution{
    public int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            if(nums[low] <= nums[high]){ //if low is less than high then nums[low] will always be the minimum
                return nums[low];
            }

            int mid = low + (high - low)/2;

            if(mid > 0 && nums[mid] < nums[mid -1]){ //if mid index value is greater than zero and mid value is less than mid-1 value then for sure it is minimum value.
                return nums[mid];
            }

            else if(nums[low] <= nums[mid]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
            }
        }

        return 888 ;
    }
}