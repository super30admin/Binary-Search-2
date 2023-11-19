//TC O(log n)
// SC O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e= nums.length-1;
        while(s<=e){

            int mid= (s+e)/2;

            //first element is always > than -1 index number so if mid==0 it is greater than left elelemt
            boolean midGtLeft= (mid==0 || nums[mid-1]<nums[mid]);

            //last element is always > than (length) index number so if mid==length-1 it is greater than right elelemt
            boolean midGtRight= (mid==nums.length-1 || nums[mid]>nums[mid+1]);

            //if mid is grater than both neighbours return
            if(midGtLeft &&  midGtRight){
                return mid;
            }
            //if mid>left
            if(midGtLeft){
                s=mid+1;
            }
            //if mid<=left no need to check right it will automatically be taken care of
            else{
                e=mid-1;
            }
        }
        return -1;
    }
}