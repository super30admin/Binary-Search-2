// Time complexity: O(log N)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* method 1: Binary Search
* move towords the higher side we will definitly find the peek
*/
public class FindPeekElement {

    public static int peakElement(int[] nums) {
        int low=0;
        int high =nums.length-1;

        while(low<=high){
            int mid = low+ (high-low)/2;
            //checking if mid is peek or not
            if((mid==0 || nums[mid]>nums[mid-1]) 
                && (mid==nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }// move lift side if high val in the lift part
            else if( mid > 0 && nums[mid-1] > nums[mid]){
                high=mid-1;
            }// move right side
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(peakElement(nums));
        
    }

}    