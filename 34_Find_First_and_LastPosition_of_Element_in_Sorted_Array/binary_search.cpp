// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt realise that we should check if the current element is first/last repetition hence went in infinite loop


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary search
// As this is a sorted array and we have to find an element, BS is the most natural.
// Now we divide the problem in finding first position and finding the last position.
// Consider finding first: When we encounter target at mid, then  either this is the first position or there are more target to left.
// So we check if this is first, if yes return mid else search in left half (excluding the mid).


#include<bits/stdc++.h>
using namespace std;

void printArr(vector<int> arr) {
    for(int a: arr) {
        cout<<a<<" ";
    }
    cout<<endl;
}

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int targetStPos = binarySearchStart(nums,target);
        if(targetStPos == -1) {
            return vector<int>{-1,-1};
        }
        int targetEndPos = binarySearchEnd(nums,target);
        return vector<int>{targetStPos,targetEndPos};
    }

private:
    int binarySearchStart(vector<int>& nums, int target) {
        int st = 0, end = nums.size()-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(nums[mid] == target && (mid == 0 || nums[mid-1] < nums[mid])) {
                return mid;
            }
            if(nums[mid] >= target) {
                end = mid-1;
            }
            else {
                st = mid+1;
            }
        }
        return -1;
    }

    int binarySearchEnd(vector<int>& nums, int target) {
        int st = 0, end = nums.size()-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(nums[mid] == target && (mid == nums.size()-1 || nums[mid+1] > nums[mid])) {
                return mid;
            }
            if(nums[mid] <= target) {
                st = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }
};

int main() {
    vector<int> nums{5,7,7,8,8,10};
    Solution S;
    printArr(S.searchRange(nums, 6));
}