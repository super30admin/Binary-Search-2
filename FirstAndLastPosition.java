class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = this.findLimit(nums, target, true);
        int last = this.findLimit(nums, target, false);
        if(first == -1) return new int[]{ -1, -1};
        return new int[]{first, last};
    }
    private int findLimit(int[] nums, int target, boolean first){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
               if(first) {
                   if(mid == low ||  nums[mid  - 1] != target) {
                       return mid;
                   }
                   else {
                       high = mid  - 1;
                   }
               }
             else{
                 if(mid == high || nums[ mid + 1] != target){
                     return mid;
                 }
                 else {
                     low = mid + 1;
                 }
             } 
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }  
        }
        return -1;
        
    }
}