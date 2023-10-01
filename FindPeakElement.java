// time: log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had problem accumulating all the return nums[i] conditions
public class FindPeakElement {
    //O(logn)
    public int findPeakElement(int[] nums) {
        
        //initialize left and right pointer
        int left = 0, right = nums.length-1;

        while(left<=right){
            //calculate mid
            int mid = left + (right-left)/2;

            //if mid is first or last element && it value greater than adjacent element
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
                
            }
            //if mid is not last or first element and its value greater than adjacent elements
            else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            //right adjacent element greater than mid
            else if(nums[mid+1]>nums[mid]){
                left = mid+1;
            }
            //left adjacent element greater or equal to mid.
            else{
                right = mid-1;
            }
        }
        return 0;
    }
}
