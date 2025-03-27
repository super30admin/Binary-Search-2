public class FindFirstAndLastElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        boolean isLeft = true; 

        result[0] = findMid(nums, target, isLeft);

        if(result[0] == -1) {
            return new int[]{-1,-1};
        }
        result[1] = findMid(nums, target, !isLeft);
        return result;
    }

    public int findMid(int[] nums, int target, boolean isLeft) {
        int low = 0; 
        int high = nums.length-1;
        int index = -1;

        while(low <= high) {
            int mid = low + (high-low) /2;

            if(nums[mid] == target) {
                index = mid;
                if(isLeft) {
                    high = mid-1;
                }
                else {
                    low = mid +1;
                }
            }

            else if(nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return index;
    }
}
