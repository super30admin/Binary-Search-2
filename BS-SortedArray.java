public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        // Find the first occurrence of the target
        int left = findLeft(nums, target);
        
        // If target is not found
        if (left >= nums.length || nums[left] != target) {
            return result;
        }
        
        // Find the last occurrence of the target
        int right = findRight(nums, target);
        
        result[0] = left;
        result[1] = right;
        
        return result;
    }

    // Function to find the leftmost (first) index of the target
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Function to find the rightmost (last) index of the target
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] result1 = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]
        
        int[] result2 = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]
        
        int[] result3 = solution.searchRange(new int[]{}, 0);
        System.out.println("Result: [" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }
}
