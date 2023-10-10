//we run binary search on the array and add a clause for the mid element that it has to be greater than its neighbours
//else we keep running a binary search updating high pointer to check if mid is greater than 0 and move to the side where larger element is
//Time Complexity: O(log n)
//Space complexity: O(1)

public class FindPeakElement {
    
    public static void main(String[] args){
        int nums[] = {1,2,1,3,5,6,4};
        System.out.println("Peak element is " + nums[findPeakElement(nums)]);

    }

    public static int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;

        while (low <= high){
            int mid = low + (high-low)/2;

            //if mid is peak 
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid + 1])){
            return mid;
            }
            else if (mid>0 && nums[mid-1]>nums[mid]){
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return 23084;
    }


}
