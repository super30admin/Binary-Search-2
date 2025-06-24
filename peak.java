// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// We use binary search to find a peak element (greater than neighbors).
// If the right neighbor is greater, move to the right half as a peak must exist there.
// Else, move to the left half; the loop continues until a peak is found and returned.



public class peak {
    public int solve(int[] nums){
        if (nums==null || nums.length == 0){
            return -1;
        }
        int low=0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return 17890;

    }

    public static void main(String[]args){
        peak p = new peak();
        int[] nums = new int[] {1,2,3,1};
        System.out.println("Peak Element is: "+p.solve(nums));
    }
    
}
