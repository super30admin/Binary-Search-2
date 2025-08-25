// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Here, we utilize the first binary search to find the first (leftmost) index of the target.
// We can early return if the first binary search returns -1.
// Then we can use the second binary search to find the second (rightmost) index of the target.

#include <vector>
#include <iostream>
using namespace std;

class Solution {
private:
    int binarySearchFirst(vector<int>& nums, int target) { // to find the first occurence of target
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != target) { // we found the left most index
                    return mid;
                } else { // we found the target but its not the leftmost index, so move high to the left half
                    high = mid - 1;
                }
            } else if(nums[mid] > target) { // normal binary search conditions
                high = mid - 1;
            } else{ 
                low = mid + 1;
            }
        }
        return -1;
    }

    int binarySearchSecond(vector<int>& nums, int target) { // to find the last occurence of target
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == nums.size() - 1 || nums[mid + 1] != target){ // we found the right most index
                    return mid;
                } else { // we found the target but its not the rightmost index, so move low to the right half
                    low = mid + 1;
                }
            } else if(nums[mid] > target) { // normal binary search conditions
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int firstIndex = binarySearchFirst(nums, target); // find first index
        if(firstIndex == -1) return {-1, -1}; // if the element was not found, early return with {-1,-1}
        int secondIndex = binarySearchSecond(nums, target); // find second index
        return {firstIndex, secondIndex};
    }
};

int main() {
    Solution solution;
    vector<int> nums = {5,7,7,8,8,10};
    vector<int> ans = solution.searchRange(nums, 7);
    cout<<"Range for 7: {"<<ans[0]<<","<<ans[1]<<"}"<<endl;
    ans = solution.searchRange(nums, 5);
    cout<<"Range for 5: {"<<ans[0]<<","<<ans[1]<<"}"<<endl;
    ans = solution.searchRange(nums, 1);
    cout<<"Range for 1: {"<<ans[0]<<","<<ans[1]<<"}"<<endl;
    return 0;
}