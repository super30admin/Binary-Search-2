// Time Complexity : O(K*log(n)) but K is small number.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only

/*
if target in the array, then perform Binary Search on left side and keep repeating repeating and update first postion
similarly for right side search and repeat Binary search and update last position. 
Approach is perform multiple Binary search. 
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;

        // find initial location
        int id = binarySearch(nums, 0, nums.length-1, target);
        if (id != -1) {
            // left side search 
            start = id;
            int first = binarySearch(nums, 0, start-1, target); 
            while (first != -1) {
                start = first;
                first = binarySearch(nums, 0, start-1, target);
            }

            // right side search
            end = id;
            int last = binarySearch(nums, end+1, nums.length-1, target); 
            while (last != -1) {
                end = last;
                last = binarySearch(nums, end+1, nums.length-1, target);
            } 
        }

        return new int[] {start, end};
        
    }

    public int binarySearch(int[] nums, int l, int r, int target) {

        while (l<=r) {
            int mid = l + (r-l)/2;
            
            if (nums[mid] == target) return mid;

            if (nums[mid] > target) r = mid-1;
            else l = mid+1; 
        }

        return -1;

    }
}
