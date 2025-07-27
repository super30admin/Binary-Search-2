class Solution {
public:
    int findMin(vector<int>& nums) {
        int l =0;
        int h = nums.size()-1;
        while(l<=h)
        {
            if(nums[l]<= nums[h])//if the element is rotated n times
             return nums[l];
            int mid = l+(h-l)/2;
            if((mid == 0 ||nums[mid]<nums[mid-1]) && (mid == nums.size()-1 ||nums[mid]<nums[mid+1]))
             return nums[mid];
            else if(nums[l]<=nums[mid])//left is sorted eleiminate it we need unsorted part
             l = mid+1;
            else
             h = mid-1;
        }
        return -1;
    }
};