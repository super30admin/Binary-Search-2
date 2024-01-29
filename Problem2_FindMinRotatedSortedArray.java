// We could observe that the minimum element is always lying on the unsorted side of the array
// So the binary search needs to be done on the unsorted half of the array
// Repeat till only 2 elements are remaining at the end to return the minimum element

class Problem2_FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        if(nums==null || nums.length==0) return -1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]) l=mid+1;
            else r=mid;
        }
        return (nums[l]<nums[r])?nums[l]:nums[r];
    }
}