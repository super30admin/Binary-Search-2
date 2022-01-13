class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        // int low =0; int high = nums.length;
        // while(low<= high){
        //     if(nums[low] < nums[high]) return nums[low];
        //     int mid = low + (high-low)/2;
        //     if(nums[low]< nums[mid]){
        //         if(min>nums[low]) {
        //             min= nums[low];
        //             low =mid+1;
        //         }
        //         else high= mid-1;
        //     }
        //     if(nums[mid]<nums[low]){
        //         if(min> nums[mid]){
        //             min = nums[mid];
        //         }
        //     }
        // }
        for (int i=0; i<nums.length; i++){
            if(min> nums[i]){
                min= nums[i];
            }
        }
        return min;
    }
}
