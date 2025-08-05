/**Time complexity O(log n)
 * space complexity O(1)
 * Did this code successfully run on Leetcode : yes
 * Did you face any problem while coding this : no
 */

/**
 * Since the array is rotated, we need to find the pivot index where the rotation happens and the element right after the pivot becomes the minimum.
 * We can use binary search to find the pivot index.
 * If the pivot index is equal to the last index, it means the array is not rotated and the minimum is the first element.
 */


class minimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int pivotIndex= PivotIndex(nums,start,end);
        if(pivotIndex==end)
        {
            return nums[0]; 
        }
        else
            return nums[pivotIndex+1];
        
    }

    public int PivotIndex(int[] nums,int start,int end){
        while(start<end)
        {
            int mid=start+(end-start)/2;
            if(mid!=0 && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            if(mid!=nums.length-1 && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            if(nums[mid]<nums[start])
            {
                end=mid-1;
            }
            if(nums[mid]>=nums[start])
            {
                start=mid+1;
            }

        }
        return start;

    }
}