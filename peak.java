//TC:O(n)
//SC:O(n)
//solved in leetcode:YES
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high = nums.length-1;
        System.out.println(high);
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            System.out.println(mid);
            // If the element is first or the only element, return, else compare with the neighbours
            if((mid==0||nums[mid]>nums[mid-1]) &&((mid==nums.length-1 || nums[mid]>nums[mid+1])))
            {
                System.out.println(mid);
                return mid;

            }
            // go to the highest side while trying to get peak
            if(nums[mid]<nums[mid+1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }


        }
        return -1;
    }
}