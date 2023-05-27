# Time Complexity : O(log n) where n = number of elements
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


/*We run binary search through the array once, find a target and binary serach again without changing the position of start*/
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res = {-1,-1};
        if(nums.size() == 0)
            return res;
        int l = 0, r = nums.size()-1;

        while(l<r)
        {
            int mid = l + (r-l)/2;

            if(nums[mid] >= target)
                r = mid;
            else
                l = mid+1;
        }

        if(nums[l]!=target)
            return res;

        res[0] = l;
        r = nums.size();
        
        while(l<r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid]>target)
            {
                r = mid;
            }
            else
            {
                l = mid+1;
            }
        }

        res[1] = l-1;
        return res;

    }
};