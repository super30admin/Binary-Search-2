//34. Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

/* 
    first getting the first occurance of the element we search for the element if we find the element 
    then we will check if the i-1 th index is less than the element, if yes then current index has the 
    first occurance else we will search for the element from first index  to the i-1 th index. similarly 
    with the last index also but will check with i+1th index.
*/

// Your code here along with comments explaining your approach
vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> ans;
    ans.push_back(firstoccurance(nums, target, 0, nums.size()-1));
    ans.push_back(lastoccurance(nums, target, 0, nums.size()-1));
    return ans;
}
int firstoccurance(vector<int> nums, int target, int low, int high)
{
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        if(nums[mid] == target)
        {
            if( mid == 0 || nums[mid] > nums[mid-1])
                return mid;
            else
                high = mid - 1;
        }
        if(nums[mid] >= target && nums[low] <= target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;
}
int lastoccurance(vector<int> nums, int target, int low, int high)
{
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        if(nums[mid] == target)
        {
            if( mid == nums.size()-1 || nums[mid] < nums[mid+1])
                return mid;
            else
            {
                low = mid + 1;
                continue;
            }

        }
        if(nums[mid] >= target && nums[low] <= target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return -1;

}

