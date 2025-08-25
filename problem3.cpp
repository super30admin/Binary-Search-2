// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The core logic behind this problem is: "To find the peak element you need to climb the mountain".
// We basically use binary search to find the mid and check if its the peak.
// If it is not the peak element, we go to the side which has the higher element because that path will eventually lead to a peak (climbing the mountain).

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.size() - 1 || nums[mid] > nums[mid + 1])) { // check if mid is the peak
                return mid;
            } else if(nums[mid + 1] > nums[mid]) { // higher element on right half, reject the left half
                low = mid + 1; 
            } else { // higher element on the left half, reject the right half
                high = mid - 1;
            }
        }
        return -1;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1,2,3,4};
    cout<<"Peak: "<<solution.findPeakElement(nums)<<endl;
    nums = {1,2,1,3,4,5,6,4};
    cout<<"Peak: "<<solution.findPeakElement(nums)<<endl;
}