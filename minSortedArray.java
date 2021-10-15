// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class minSortedArray {
    public static int findMin(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int mid;

        if(nums.length==0)
          return -1;
        if(nums.length==1)
            return nums[0];

        while(start<=end){
            mid = start + (end-start)/2;
            if(mid>0 && nums[mid-1]>nums[mid])
                return nums[mid];
            
            if(nums[start]<=nums[mid] && nums[mid]>nums[end]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return nums[start];      
    }

    public static void main(String args[]){
        int numbers[] = {11,13,15,17};
        int result;
        result = findMin(numbers);
        System.out.println("The minimum element is: " + result);
    }
}
