// 1. Use binary search to find any peak in unsorted array.
// 2. There would definitely be peak if value is increasing in either direction of mid element.
// 3. Return value if mid element is greater than both neighbour elements.

class Solution {
public:
    int binarys(vector<int>& nums,int f,int l){
        int mid= f + (l-f)/2;
        if(f>l ){
            return f;
        }
        if(( (mid-1) < f || (nums[mid]>nums[mid-1]) ) && ((mid+1) > l || (nums[mid]>nums[mid+1])) ){
            return mid;
        }
        else if( ((mid-1)>=f) &&  nums[mid]<nums[mid-1]){
            return binarys(nums,f,mid-1);
        }
        else{
            return binarys(nums,mid+1,l);
        }
    }
    int findPeakElement(vector<int>& nums) {
        int f=0,l=( nums.size()-1 );
        return binarys(nums,f,l);
    }
};