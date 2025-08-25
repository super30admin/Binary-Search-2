// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The logic here is the minimum (pivot) will always lie in the unsorted half & atleast one half will always be sorted in a rotated sorted array.
// If nums[low] <= nums[high], the array is already sorted, therefore nums[low] is the minimum element.
// Otherwise check if nums[mid] is the pivot, if its not, move the low or high pointer to the unsorted half accordingly.

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]) { // check if array is already sorted
                return nums[low];
            }
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] < nums[mid + 1])) { // check if mid is the minimum
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { // left half sorted, minimum will lie in the right half
                low = mid + 1;
            } else { // right half sorted, minimum will lie in the left half
                high = mid - 1;
            }
        }
        return -1;
    }
};

int main() { 
    Solution solution;
    vector<int> nums = {4,5,6,0,1,2};
    cout<<"Min: "<<solution.findMin(nums)<<endl;
    nums = {1,2,3,4,5}; // already sorted array
    cout<<"Min: "<<solution.findMin(nums)<<endl;
    return 0;
}