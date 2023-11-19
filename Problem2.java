// TC O(log n)
// SC O(1)

class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){

            // array is already sorted
            if(nums[s]<=nums[e]){
                return nums[s];
            }

            int mid= (s+e)/2;

            // Mid is at pivot element i.e Min element
            if(mid!=0 && nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            // Pivot is to left of Mid. So Right sorted. So Min is on left
            if(nums[mid]<nums[e]){
                e=mid-1;
            }
            //Pivot is to right of Mid. So Left sorted. So Min is on right
            else{
                s=mid+1;
            }
        }
        return 50001;
    }
}