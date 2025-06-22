//time complexity - O(log(n))
//space complexity - O(1)

//approach
    //found mid, if mid = target then for finding first index go to the left and for last index go to the right
    //if mid > target repeat this in left array
    //if mid < target repeat this in right array

#include <iostream>
#include <vector>
using namespace std;

class Solution {
    private:
        int binarysearch(vector<int>& nums, int target, bool findingFirst){
            int low = 0;
            int high = nums.size() -1;
            int result = -1;
    
            while(low <= high){
                int mid = low + ((high-low)/2);
                if(nums[mid] == target){
                    result = mid;
                    if(findingFirst){
                        high = mid -1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                else if(nums[mid] > target){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
    
            return result;       
    
        }
    public:
        vector<int> searchRange(vector<int>& nums, int target) {
            int FirstIndex = binarysearch(nums, target, true);
            int SecondIndex = binarysearch(nums, target, false);
            return {FirstIndex, SecondIndex};
        }
    };