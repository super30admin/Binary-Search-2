// 1. To find minimum element analyse which half part in binary search is unsorted or sorted.
// 2. If array is sorted and target is between the range(first,mid || mid,last) eliminate other half.
// 3. Similar for unsorted part of binary search.

class Solution {
public:
    int binarys(vector<int>& nums,int f,int l,int target){
        int mid= f + (l-f)/2;
        if(f>l){
            return -1;
        }
        int fl=0;
        if(nums[mid]<nums[l]){
            fl=1;
        }
        if(fl==0){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target && nums[f]<=target){
                return binarys(nums,f,mid-1,target);
            }
            else{
                return binarys(nums,mid+1,l,target);
            }
        }
        else{
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target && nums[l]>=target){
                return binarys(nums,mid+1,l,target);
            }
            else{
                return binarys(nums,f,mid-1,target);
            }
        }
    }
    int search(vector<int>& nums, int target) {
        int f=0,l=nums.size()-1;
        return binarys(nums,f,l,target);
    }
};