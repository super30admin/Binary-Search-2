#include<iostream>
#include<vector>
using namespace std;
/*
se binary search to find the pivot point, where the rotation occurred.
If the subarray from low to high is sorted, return nums[low].
Otherwise, check whether the left or right half is sorted and adjust the search accordingly.
*/
class Solution{
public:
    int findMin(vector<int>& nums) {
        //using Binary search
        //TC: O(log n), SC: O(1)
        int low=0, high=nums.size()-1;
        while(low<high){
            int mid=low+(high-low)/2;
            //if((mid==low || nums[mid]<nums[mid-1]) && (mid==high || nums[mid] < nums[mid+1])) 
               //return nums[mid];
            if(nums[mid]<=nums[high]) high=mid; //left sorted array
            else low=mid+1; 
        }
        return nums[low];
    }
};
int main(){
return 0;
}