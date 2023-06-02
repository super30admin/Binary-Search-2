// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std;

class Solution {

    int findLeft(vector<int>& arr, int target){
        int low = 0;
        int high = arr.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == 0){
                    return mid;
                }
                else if(arr[mid] != arr[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    int findRight(vector<int>& arr, int target){
        int low = 0;
        int high = arr.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == arr.size() - 1){
                    return mid;
                }
                else if(arr[mid] != arr[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int leftIdx = findLeft(nums, target);
        int rightIdx = findRight(nums, target);
        return vector<int>{leftIdx, rightIdx};
    }
};