//time complexity - O(logn)
//space complexity - O(1)

//approach
    //run till low < high
    //find mid element 
    // as i tis rotated sorted array so if arr[mid] > arr[high] then minimum is on right side 
    //and if arr[mid] < arr[high] then minimum is on left side 
    //repeat till low  = high 
    //if low = high return arr[low]



#include <iostream>
#include<vector>
using namespace std;

class Solution {
    public:
        int findMin(vector<int>& nums) {
            int low = 0;
            int high = nums.size() - 1;
            while(low < high){ //iterate till low = high
                int mid  = low + ((high-low)/2);
                if(nums[mid] > nums[high]){//min is in right side 
                    low = mid + 1;
                }
                else{ // min is on left side or mid 
                    high = mid ;
                }
            }
            return nums[low]; // return low position element 
        }
    };
