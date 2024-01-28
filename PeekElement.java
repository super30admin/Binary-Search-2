// Time Complexity:O(log n)
// Space Complexity: O(n)
// this problem was solved on leet code.
// Approach: check if mid element is gretaer than neighbouring elements. else move toward the number that is greater than the middle element





class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0 || nums==null) return -1;
        int low=0;int n=nums.length;int high=n-1;
        while(low<=high){
            
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid== n-1 ||nums[mid]>nums[mid+1]))return mid;
            else if(mid!=0 && nums[mid]<=nums[mid-1]){
                high=mid-1;
            }
            else low=mid+1;
        }
        return -1;
    }
}