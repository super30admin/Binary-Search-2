/* Time complexity: O(log n) */

/* All test cases passed on leetcode */

/* Appraoch:
  1. Using binary search, the array is divided to the point at which only
  single element remains in the array that is the peak element.
  2. Find the mid index element, compare the mid element with the element at mid + 1,
  if the element at mid is greater than the element at mid + 1, then the peak exists 
  on the left side of the mid and thus, the right pointer will be updated to mid
  else if the element at mid is smaller than the element at mid + 1 then the peak exists
  at the right of the mid element therefore the left pointer is updated to mid + 1
  3. Repeat this process until only one element is left and that element would be the peak element
*/



class findPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return searchPeak(nums, 0, n - 1);
    }
    public int searchPeak(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        int mid = (left + right)/2;
        if(nums[mid] > nums[mid + 1]){
            return searchPeak(nums, left, mid);
        }
        return searchPeak(nums, mid + 1, right);
    }
}