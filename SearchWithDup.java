class SearchWithDup {
    
    public void binarySearchHandler(int[] nums, int low, int high, int target,int[] result){
        if(low > high)
            return;
        int mid = low + (high-low)/2;
        if(nums[mid] == target){            
            if(result[0] == -1)
                result[0] = mid;

            if(mid > result[1]){
                result[1] = mid;
            }
            if(mid < result[0])
                result[0]  = mid;         
        }

        if(nums[mid] >= target){
            binarySearchHandler(nums, low, mid-1, target, result);
        }
        if(nums[mid] <= target){
            binarySearchHandler(nums, mid+1, high, target, result);
        } 
    }
    
    public int[] search(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int[] result = new int[]{-1,-1};
        
        binarySearchHandler(nums, low, high, target, result);
        if(result[0] != -1 && result[1] == -1)
            result[1] = result[0];
        return result;
    }

    public static void main(String[] args){
        System.out.println("Search with Duplicates implementation");
        SearchWithDup obj = new SearchWithDup();
        int[] nums = {0,0,0,0,0,1,1,2,2,3,4,4,5,5,5,5,6,7};
        int target = 0;
        int[] result = obj.search(nums, target);
        System.out.println("0: " + result[0] + " 1: " + result[1]);
    }
}