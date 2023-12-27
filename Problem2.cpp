
//The given C++ code implements a binary search-based approach to find the minimum element in a rotated sorted array. 
//The algorithm maintains a search range using low and high indices and updates the minimum value (ans) during each iteration.
// The search narrows down to the unsorted part of the array, adjusting the indices based on the comparison between the elements at the low and mid points.
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int low = 0 , high = n-1;
        int ans = INT_MAX;

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(nums[low] <= nums[mid])
            {
                ans = min(ans,nums[low]);
                low = mid + 1;

            }
            else
            {
                ans = min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
};