// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// I used binary search to find the first and last positions of the target in the sorted array. 
// The first search checks if the current match is the first occurrence by looking at the previous element.
// The second search does the same for the last occurrence by checking the next element.

class Solution {
public:
    int binarySearch(vector<int>& nums, int target, bool findFirst) {
        int low = 0, high = nums.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        return {first, last};        
    }
};