/*
 *  Find Minimum in Rotated Sorted Array
 */

class FindMinimumElement {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2; //condition to check integer overflow
            
            //this condition means that array is sorted
            if(nums[low] <= nums[mid] && nums[high] > nums[mid]){
                return nums[low];
            }

            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }

            //check if left side is sorted, chances are minmum number will be found in unsorted array
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        FindMinimumElement solution = new FindMinimumElement();

        // Test case 1: Example test case
        int[] nums1 = {3,4,5,1,2};
        int result1 = solution.findMin(nums1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + result1);

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int result2= solution.findMin(nums2);
        System.out.println("\nTest Case 2:");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + result2);

        // Test case 3
        int[] nums3 = {1};
        int result3 = solution.findMin(nums3);
        System.out.println("\nTest Case 3:");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + result3);

}
}