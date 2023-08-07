//apply one bs for the first occurence of the element and another one for the last occurence of the element
//in the bs for the first occurence, apply bs to find the target, and once the target is found, get the first occurence by moving to left
// apply the same above the last element as well but to get the last occurence, keep shifting to the right, until we reach last or to the ele greater than target

class ElePosSortedArray {
    private int binarySearchFirst(int[] nums, int target ){
        int low = 0;
        int high = nums.length -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1]) return mid;
                else {
                    // keep on moving towards left until we find first occurence
                    high = mid -1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int low, int high, int target ){
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length -1 || nums[mid] < nums[mid+1]) return mid;
                else {
                    // keep on moving towards right until we find first occurence
                    low = mid+1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        //null
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = 0;
        int high = nums.length -1;
        // if target in not in range of ele
        if(nums[0] > target || nums[high] < target) return new int[]{-1,-1};
        // if all the ele in the array are equal
        if(nums[low] == nums[high]) return new int[]{low, high};
        int first = binarySearchFirst(nums, target);
        // if the fist occurence is not found, then there is no point in finding the last occurence, we simply have to return {-1, -1}
        if(first == -1) return new int[]{-1,-1};
        int last = binarySearchLast(nums, first, high, target);
        return new int[]{first,last};
    }
}
