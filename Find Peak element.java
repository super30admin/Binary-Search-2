//tc:O(logn), sc: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int first=0;
        int last=nums.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
           if((mid==0 || nums[mid]>=nums[mid-1]) && (mid==last||nums[mid+1]<=nums[mid]))
               return mid;
            else if(nums[mid]<nums[mid+1])first=mid+1;
            else last=mid-1;
        }
        return 0;
	}
}