class Solution{
    public int[] searchRange(int[] nums, int target){
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }
    private int findBound(int[] nums, int target, boolean findFirst){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(if nums[mid] == target){
                ans = mid;

                if(findFirst){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
      return ans;

    }
  }