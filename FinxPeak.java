// THis algorithm uses the concept of binary search and moves the mid element towards the side where there is increase in the steep from mid pointer.
class Solution {
    public int findPeakElement(int[] nums) {
        int i =0, j=nums.length-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            // If its a peak return immediately
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])) {
                return mid;
            }
            // If there is a increase in steep move towards right
            if(mid!=0 && nums[mid-1]>nums[mid]) {
                j=mid-1;
            // If there is a increase in steep on left move towards right
            } else if(mid!=nums.length-1 && nums[mid+1]>nums[mid]) {
                i=mid+1;
            }
        }
        // We will end up in the index where there is steep
        return i;
    }
}
