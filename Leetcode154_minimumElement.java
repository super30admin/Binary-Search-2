//Time complexity: O(logn)
//Space Complexity:O(1)
//code executed successfully : yes 
class Solution {
    public int findMin(int[] nums) {
       if(nums==null || nums.length==0)return -1;
        int low =0;
        int high= nums.length-1;
        if (nums.length==1) return nums[0];
        if (nums[0]<nums[high])
        {
        return nums[0];
        }
        while(low<=high)
        {
            int mid = low +(high-low)/2;

            if(nums[low]<=nums[mid])
            {
                //left sorted 
                low = mid+1;
            }
            else {
                //right sorted 
                high= mid-1;
            }
            if(nums[mid] > nums[mid+1])
            return nums[mid+1];
            else if(nums[mid -1] >nums[mid])
            return nums[mid];
            

        }
    return -1;
    }
}
