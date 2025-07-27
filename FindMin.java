//Here since the given array is a rotated sorted array in each iteration there will be a half that is definitely sorted
// and since the arrays being rotated around along the pivot, the pivot would lie in the unsorted part
// and I'm using binary search to identify the sorted part and move to the unsorted part till we find the minimum element.
// so this runs in O(logn)
//space complexity being in constant time since we are not using any other additional space 

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high])return nums[low];//cheching if the array is already sorted
            if((mid==low||nums[mid]<nums[mid-1])&&(mid==high||nums[mid]<nums[mid+1]))return nums[mid];
//eliminating the sorted part
            if(nums[low]<=nums[mid])low=mid+1;
            else high=mid-1;
        }
        return -1;
    }

}
