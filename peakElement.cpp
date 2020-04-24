// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting it in O(log n)


// Your code here along with comments explaining your approach
// 1. Linear traversal- If number is greater than the right neighbor then it is a peak
// 2. Place INT_MIN as last element to take care of single element array 
// 3. Since we can return any peak, just return first element when the above condition is true else return second last element since last is INT_MIN


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        nums.emplace_back(INT_MIN);
        int i=0;
        for(; i<nums.size()-1; i++){
            if(nums[i]>nums[i+1])
                return i;
        }
        return i-1;
    }
};
