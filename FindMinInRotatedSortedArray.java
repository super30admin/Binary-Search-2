
// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//Using binary search approach to find the min element

public class FindMinInRotatedSortedArray {
        public int findMin(int[] nums) {
            int l = 0;
            int h = nums.length-1;
            while(l<=h){
                if(nums[l] <= nums[h]){
                    return nums[l];
                }
                int mid = l + (h-l)/2;
                if((mid==0 || nums[mid-1] > nums[mid]) &&
                        (mid==nums.length-1 || nums[mid+1] > nums[mid])){
                    return nums[mid];
                }
                else if(nums[l] <= nums[mid]){
                    l = mid+1;
                }
                else {
                    h = mid-1;
                }
            }
            return -1;

        }
    }