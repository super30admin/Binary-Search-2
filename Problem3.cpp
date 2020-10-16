//LeetCode #162. Find Peak Element
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/*
    After calculating the the middle index, we check if its
    left neighbor and right neighbor are smaller than the middle element.
    If yes, we can say that the peak is found at middle index. If not,
    we need to move to the element which is greater thean the middle element.
    So, we will change the low or high pointer accordingly.
*/

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 0) return -1;
        
        int low = 0;
        int high = nums.size()-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == nums.size()-1 || nums[mid] > nums[mid+1]
              && (mid == 0 || nums[mid] > nums[mid-1]))
                return mid;
            else if(mid == nums.size()-1 || nums[mid] < nums[mid+1])
                low = mid+1;
            else if(mid == 0 || nums[mid] < nums[mid-1])
                high = mid-1;
        }
        return -1;
    }
};
