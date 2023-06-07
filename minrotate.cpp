
// TC:O(logN)
// SC:O(1)

// Approach:
// By observing ,minimum always present on the unsorted side ,
// if it is sorted value at low index is the minimum value.,
// Minimum is lying in unsorted part of the array,And two base cond is mid+1 > mid <mid-1, && nums[low]<nums[mid]

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low=0;
        int high=nums.size()-1;

    //   Moving towards unsorted array if there is no unsorted array in search space return nums[low]

        while(low<=high)
        {
            if(nums[low]<nums[high])
             return nums[low];

            int mid=low+(high-low)/2;

            if((mid==low || nums[mid]<nums[mid-1]) && (mid==high || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return 0;
    }
};