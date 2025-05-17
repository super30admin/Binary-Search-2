//Time Complexity: O(logn)
//Space Complexity: O(1)
//Approach: use binary search. Compare mid element with neighbors and search for peak in the half where neighbor is greater then mid. This half will definetely have the peak
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==nums.length-1 ||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid!=0 && nums[mid]<nums[mid-1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}