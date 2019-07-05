//
// Created by shazmaan on 7/5/2019.
//
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int findMin(vector<int>& nums) {
        return nums[findRotPoint(nums,0,nums.size()-1)];
    }

private:
    int findRotPoint(vector<int>& nums,int low, int high){
        int mid;
        while(low!=high){
            mid = (low+high)/2;
            if((mid-1)>=0 && (nums[mid]<nums[mid-1])){
                return mid;
            }else if(nums[mid]>nums[low]){
                low=mid;
            }else if(nums[mid]==nums[low]){
                if(nums[mid]<nums[high]){
                    return 0;
                }
                return nums.size()-1;
            }else if(nums[mid]<nums[low]){
                high = mid;
            }
        }
        return low;
    }
};

int main(){
    vector<int> vec{3,4,5,1,2};
    Solution s; cout<<s.findMin(vec)<<endl;
    return 0;
}