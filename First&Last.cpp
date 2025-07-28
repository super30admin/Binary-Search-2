#include<iostream>
#include<vector>
using namespace std;
/*
->Perform binary search to locate first elements index
->if target is not found return {-1,-1}
->other wise, find the second elements index and return first,second
TC: O(log n), SC: O(1)
*/
class Solution {
private:
    int binarySearchFirst(vector<int>& nums, int target, int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target) return mid;
                else high=mid-1;
            }else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

    int binarySearchSecond(vector<int>& nums, int target, int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.size()-1 || nums[mid+1]!= target) return mid;
                else low=mid+1;
            }else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first=binarySearchFirst(nums,target,0,nums.size()-1);
        if(first== -1) return {-1,-1};
        int second=binarySearchSecond(nums,target,first,nums.size()-1);
        return {first,second};
    }
};

int main(){
    return 0;
}