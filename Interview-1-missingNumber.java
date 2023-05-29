// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int missingNumber(int[] nums) {

        int l = 0;
        int h = nums.length-1;

        int mid = 0;

        while(l<=h) {
            mid = l + (h-l)/2;

            // 
            if(mid == nums[mid]-1) {
                // left is not missing a number
                l = mid +1;
            } else {
                //right is not missing a number
                h = mid-1;
            }   
        }
        
        // if last is missing then nums[mid]-1==mid, hence return nums[mid]+1
        if (mid == nums[mid]-1) return nums[mid]+1; 
        
        return nums[mid]-1;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,2,3,4,5,6,8,9}; // 7 is missing
        int[] nums2 = new int[] {2,3,4,5,6,7,8,9}; // 1 is missing
        int[] nums3 = new int[] {1,2,3,4,5,6,7,8}; // 9 is missing
        int[] nums4 = new int[] {2}; // 1 is missing
        int[] nums5 = new int[] {1}; // 2 is missing

        Solution obj = new Solution();

        System.out.println(obj.missingNumber(nums1));
        System.out.println(obj.missingNumber(nums2));
        System.out.println(obj.missingNumber(nums3));
        System.out.println(obj.missingNumber(nums4));
        System.out.println(obj.missingNumber(nums5));
        
    }

}
