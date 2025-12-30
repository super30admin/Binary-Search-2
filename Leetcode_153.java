//Way 1:
//Perform binary search. Either of the side will be sorted. If both sides are sorted, then that part of array is sorted and min element will be starting positon. So, we will return element at 0th index.
//If only one of the array is sorted, then right side portion will not be sorted. Means min element will present at right side. So, shift low to mid+1 
//TC: O(log n); SC: O(1)
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        int low=0,high=n-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[mid] && nums[mid]<nums[high]){
                return nums[low];
            }
            
            
            if((mid==0 || nums[mid]<=nums[mid-1]) && (mid==n-1 || nums[mid]<=nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
               low=mid+1;
            }else{
                high=mid;
            }
        }

        return nums[low];
    }
}

//Way 2:

class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        int low=0,high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[mid] && nums[mid]<nums[high]){
                return nums[low];
            }
            
            
            if((mid==0 || nums[mid]<=nums[mid-1]) && (mid==n-1 || nums[mid]<=nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
               low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }
}
