//The provided C++ code implements a binary search-based approach to find the first and last occurrences of a target element in a sorted vector.
// The firstOccurance function uses a modified binary search to find the leftmost occurrence of the target, while the lastOccurance function finds the rightmost occurrence.
// The searchRange function then utilizes these two functions to return a vector containing the indices of the first and last occurrences of the target, or {-1, -1} if the target is not present in the vector.
class Solution {
public:
int firstOccurance(vector<int>&nums , int target)
{
    int n = nums.size();
    int low = 0, high = n-1, first = -1;

    while(low <= high)
    {
        int mid = (low+high)/2;

        if(nums[mid] == target)
        {
            first = mid;
            high = mid-1;
        }
        else if(nums[mid] < target)
        {
            low = mid+1;
        }
        else
        {
            high = mid -1;
        }

    }
    return first;
}
int lastOccurance(vector<int>&nums , int target)
{
    int n = nums.size();
    int low = 0, high = n-1, last = -1;

    while(low <= high)
    {
        int mid = (low+high)/2;

        if(nums[mid] == target)
        {
            last = mid;
            low = mid+1;
        }
        else if(nums[mid] < target)
        {
            low = mid+1;
        }
        else
        {
            high = mid -1;
        }

    }
    return last;
}
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = firstOccurance(nums,target);
        if(first == -1) return {-1,-1};
        int last = lastOccurance(nums,target);
        return{first, last};
    }
};