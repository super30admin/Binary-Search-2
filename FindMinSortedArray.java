//we run a binary search on the array 
//first check if the array is sorted, if the array is sorted then return low index element
//else we ignore the sorted side of array because the min element is present on the unsorted side of array

//Time complexity : O(log n)
//Space complexity : O(1)

public class FindMinSortedArray {

    public static void main(String[] args)
    {
        int nums[] = {4,5,6,7,1,2,3};
        System.out.println("min element is " + findMin(nums));
    }

    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high)
        {
            if(nums[low]<nums[high])
            {
                return nums[low];
            }
            
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }

        } 

        return 1;
    }
    
}
