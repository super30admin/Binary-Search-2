// In this problem, we are using binary search algorithm to determine the
// minimum value from the list of elements in an array
// the time complexity of this implementation is O(log n)
public class FindPeak {
    public int findPeak(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        FindPeak solution = new FindPeak();
        int peakIndex = solution.findPeak(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
