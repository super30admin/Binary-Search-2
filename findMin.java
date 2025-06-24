// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// We use binary search to efficiently locate the minimum in a rotated sorted array. 
// At each step, we compare the middle element with the high one to decide whether to search the left or right half. 
// When the loop ends, the low pointer will be at the smallest element.



public class findMin {
    public int solve(int[] nums){
        int low=0;
        int high = nums.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[low];
    }

    public static void main(String[]args){
        findMin ob = new findMin();
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println("Minimum element is: "+ob.solve(nums));
    }
    
}
