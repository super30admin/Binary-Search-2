package Problem2;

public class MinimumINRotatedArray {

    static int getMinimum(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n-1;
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = (high - low) / 2 + low;

            if(mid != 0 &&  nums[mid] < nums[mid - 1])  return nums[mid];
            if(mid != n - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if(nums[low] <=  nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println("The minimum in a rotated sorted array " + getMinimum(nums));
    }
}
