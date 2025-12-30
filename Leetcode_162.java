//Way 1
//Applying binary search on the given array. If the mid element is bigger than it's adjacent elements, returning the mid. Else, moving to the side which is having bigger element than middle element. And performing binary search on it.

//TC:O(log n); SC: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(mid==0 || nums[mid]>nums[mid-1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
        
    }
}

//Way 2
//Applying binary search on the given array. If the mid element is bigger than it's adjacent elements, returning the mid. Else, moving to the side which is having bigger element than middle element. And performing binary search on it.

//TC:O(log n); SC: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(mid==0 || nums[mid]>nums[mid-1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        return low;
        
    }
}
