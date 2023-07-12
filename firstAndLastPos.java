// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    int lowForright;
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first  = binaryForleft(nums, target);
        if(first == -1) return new int[] {-1,-1};
        lowForright = first;
        int last = binaryForright(nums, target);
        if(last == -1) return new int[] {-1,-1};
        return new int[] {first,last};
    }
    private int binaryForleft(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid]>nums[mid-1]) return mid;
                else high = mid-1;
            }
            else if(nums[mid]> target){
                high =mid-1;
            }
            else low =mid+1;
        }
        return -1;
        
    }

    private int binaryForright(int[] nums, int target){
        int n = nums.length;
        int low = lowForright;
        int high = n-1;
        
       while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==n-1 || nums[mid]<nums[mid+1]) return mid;
                else low =mid+1;
            }
            else if(nums[mid]> target){
                high =mid-1;
            }
            else low =mid+1;
        }
        return -1;
    }
}