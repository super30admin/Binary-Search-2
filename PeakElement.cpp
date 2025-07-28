#include<iostream>
#include<vector>
using namespace std;
/*
Apply binary search and check the elements on the left and right of mid
Compare them and if mid element is the largest
Return the mid element
*/
class Solution{
public:
    int findPeakElement(vector<int>& nums) {
        //Binary search
        //TC: O(log n) , SC: O(1)
        int low=0, high=nums.size()-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if((mid==low || nums[mid]>nums[mid-1]) && (mid==high || nums[mid]>nums[mid+1])) return mid;
            if(nums[mid+1]>nums[mid]) low=mid+1;
            else high=mid-1;        
        }
        return low;
    }
};
int main(){
return 0;
}