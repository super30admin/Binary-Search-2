// This code involves solving by binary search where we just move over towards the unsorted elements as its pretty sure smallest element will be available in that range
class Solution {
    public int findMin(int[] nums) {
        int i=0, j=nums.length-1;
        while(i<j) {
            int mid = i+(j-i)/2;
            // If right part is sorted move towards left
            if(nums[mid]<=nums[j]) {
                // making sure its not mid-1 as it might beat the corner case where the mid itself is the smallest element
                j=mid;
            } else {
                i=mid+1;
            }
        }
        return nums[i];
    }
}

