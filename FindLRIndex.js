class FindLRIndex {
     private static int find(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = find(nums, target, true);

        if (left == nums.length || nums[left] != target) {
            return result;
        }

        result[0] = left;
        result[1] = find(nums, target, false)-1;

        return result;
    }
    public static void main (String[] args) {
		int nums[]={1,4,5,8,8,10};
		int target=8;
		int[] arr =searchRange(nums,target);
		System.out.println("["+arr[0]+","+arr[1]+"]");
		
	}
}