// Time Complexity :O(n)
// Space Complexity :No extra space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        //Arrays.sort(nums);
        // return nums[0];
        int n = nums.length;
        int low = 0; int high = nums.length -1;

        while(low <= high){

            if(nums[low] <= nums[high]){ //if array is sorted return the first element
                //System.out.println(mid);
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            else if(nums[low] <= nums [mid]){ //we check by this if left side is sorted or not
                low = mid +1;
            }
            else if (nums[high] >= nums [mid]){
                high = mid -1;
            }

        }
        return -1;
    }
}
//Note: first we check if array is sorted or not , if its sorted we return the first element,
//2 : we check if the m is smallest from its neighbouring elements or not, if its the smallest then, return that mid element
//3: here PIVOT always lies to the unsorted side , so we have to check which side is sorted or not , so here what we do is
// CHECK it with low instead of min -1 , as min -1 gives out of bounds issue : line 18
// if LOW <= MID means that left part is sorted and now we move to the other side of M where pivot lies (always on unsorted side)

//Same for high; if high > mid meas that side is sorted and me reduce high range by doing high =s mid -1

