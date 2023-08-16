// Time Complexity :O(n)
// Space Complexity :No extra space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0; int high = n-1;
        while(low <= high){
            int mid = high-low/2;
            if((mid==0|| nums[mid] > nums[mid - 1]) &&(mid == n-1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid] > nums[mid -1]){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;

    }
}
//Here , you have to follow max mumber, you have to find the peak, then you have to climb the mountain
