// time complexity: O(logn) 
// space comp: O(1);
//leetcode: yes


public class FindMinSortedArray {


    public int findMin(int[] nums) {
        
        if (nums.length==0) return -1;


        int high= nums.length-1;
        int low= 0;
        while(low<high)
        {
            int mid  = low +(high-low)/2;
             if(nums[mid]<nums[mid-1]) return nums[mid];
             else if(nums[low]<= nums[mid] && nums[mid]>nums[high]) low=mid+1;
             else high=mid+1;


        }

        return nums[low];
    }

}
