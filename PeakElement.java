// Time complexity : O(logn)
// Space complexity : O(1)
public class PeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > 0 && mid < nums.length - 1){
                if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1]))
                    return mid;
                else if (nums[mid - 1] > nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (mid == 0) {

                if (nums[mid] > nums[mid + 1])
                    return mid;
                else
                    return mid + 1;

            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1])
                    return mid;
                else
                    return mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        
        int[] arr = {1,2,1,3,5,6,4};
        int result = findPeakElement(arr);
        System.out.println(result);
    }

}
