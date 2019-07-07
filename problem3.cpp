#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution{
    public:

        int PeakElement(vector<int>&nums)
        {
            int start = 0;
            int end = nums.size() - 1;
            int middle;
            
            while(start <= end)
            {
                middle = start + (end - start)/2;

                if(middle == 0 || nums[middle] > nums[middle - 1] &&
                   middle == end || nums[middle] > nums[middle +1])

                   return middle;
                
                else if(middle < end || nums[middle] < nums[middle +1])
                    start = middle +1;
                else
                    end = middle -1;

            }
            return -1;
        }
};