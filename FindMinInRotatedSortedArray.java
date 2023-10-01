// time: log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had problem accumulating all the return nums[i] conditions

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        //if input is empty
        if(nums==null||nums.length==0) return -1;

        //initializing low and high
        int low = 0, high = nums.length-1;

        while(low<=high){
            //if current partition is sorted
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            //if current partition is not sorted
            
            //calculating mid
            int mid = low+(high-low)/2;

            //if  mid element is the minimum
            //checking left and right edge cases as well.
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){                
                return nums[mid];
            }
            //if left half is sorted, minimum must be in right unsorted part, update low
            else if(nums[low]<=nums[mid]){
                low = mid+1;
            }
            //if right half is sorted, minimum must be in left unsorted part, update high
            else{
                high = mid-1;
            }
            
        }
        return -1;
    }
}
