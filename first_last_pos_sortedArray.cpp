#include<bits/stdc++.h>
using namespace std;
class Solution {
private:
    int Bs_S(vector<int>&nums,int low,int high,int target){
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    int Bs_E(vector<int>&nums,int low,int high,int target){
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.size()-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0)
            return {-1,-1};
        int n = nums.size();
        if(target < nums[0] || target > nums[n-1])
            return {-1,-1};
        int startidx = Bs_S(nums,0,n-1,target);
        if(startidx == -1){
            return{-1,-1};
        }
        int endidx = Bs_E(nums,startidx,n-1,target);
        return {startidx,endidx};
    }
};