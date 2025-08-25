//Time Complexity - O(log n)
//Space Complexity - O(1)
//Did it run on leetcode - yes

//Your approach
/*
Use binary search on unsorted array and find middle 
check for its immediate neighbors and compare
traverse to the side that is greater than middle element
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l<=h) {
            int mid = l + (h-l)/2;
            if ((mid==0 || nums[mid] > nums[mid-1]) && (mid == h || 
            nums[mid]>nums[mid+1])) {
                return mid;
            } else if(nums[mid+1]>nums[mid]) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return -1; 
    }
}
