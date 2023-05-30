package BinarySearch2;
/*
 * Here we use the concept that the pivot will always lie in the unsorted part of the array after choosing a mid.
 * So, we check for which part is sorted and ignore that half.
 * Time Complexity :
 * O(logN)
 * 
 * Space Complexity :
 * Space complexity is O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */
public class Problem2 {

    public int findMin(int[] nums) {

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            if(nums[low]<nums[high]){
                return nums[low];
            }

            int mid= low+(high-low)/2;

            if((mid==nums.length-1 || nums[mid]<nums[mid+1]) && (mid==0||nums[mid]<nums[mid-1]))           {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                //left sorted
                low=mid+1;
            }
            else if(nums[high]>=nums[mid])
                high=mid-1;
        }

        return -1;
        
    }

}
