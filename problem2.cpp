#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution{
    public:

    int findMin(vector<int>& arr) {
        
        int start = 0;
        int end = arr.size() - 1;
        int middle;

        while(start < end)
        {   
            middle = start + (end - start)/2;
            if(arr[start] < arr[end]) return arr[start];
            if(arr[middle] < arr[end]) end = middle;
            else start = middle + 1;
        }
        return arr[start];

    }
};
