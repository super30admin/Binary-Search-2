// Time complexity : O(log n)
// Space complexity : O(1)

class PeekElementSolution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end)
        {
            int mid=(start+end)/2;
            if(nums[mid]>nums[mid+1])
            {
                end=mid;
            }
            else
                start=mid+1;;
        }
        return start;
    }
    
}
