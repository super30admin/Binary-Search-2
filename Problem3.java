package BinarySearch2;

/*
 * Once we find the mid element we check if the left neighbour is greater and if it is we keep moving left 
 * else we move right. As we keep moving towards greater element we either reach the end of array or inevitably an element with both neighbours being smaller.
 * 
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
public class Problem3 {
	
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }

        int peakIndex=binarySearch(nums,0,nums.length-1);

        return peakIndex;
    }

    private int binarySearch(int[] nums,int low,int high){

    while(low<=high){
        int mid =low+(high-low)/2;

        if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
            return mid;
        }
        else if(nums[mid+1]>nums[mid]){
            low=mid+1;
        }
        else if(nums[mid-1]>nums[mid]){
            high=mid-1;
        }
    }

    return -1;}
}
