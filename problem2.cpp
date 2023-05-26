# Time Complexity : O(log n) where n = number of elements
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


/*We run binary search through the array and keep comparing the left and right pointers*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0, r = nums.size()-1;
        while(l < r){

            int mid = l + (r-l)/2;
            
            if(nums[mid] > nums[r])
                l = mid+1;
            else if(nums[mid] < nums[r])
                r = mid;
            else return 
                nums[r];
        }
        return nums[l];   
    }
};