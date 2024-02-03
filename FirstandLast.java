package s30;

public class FirstandLast {
	private int binarySearchFirst(int [] arr, int low, int high, int target){
        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]==target){
                if(mid == 0 || arr[mid]> arr[mid-1]){
                    return mid;
                }
                else{
                    high =mid-1;
                }
            }
            else if(arr[mid]>=target){
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int [] arr, int low, int high, int target){
        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]==target){
                if(mid == arr.length-1 || arr[mid]< arr[mid+1]){
                    return mid;
                }
                else{
                    low =mid+1;
                }
            }
            else if(arr[mid]>=target){
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
       if(nums== null || nums.length==0){
           return new int[]{-1,-1};
        } 
        int n = nums. length;
        if(nums[0] > target || nums[n-1] < target) 
            return new int[]{-1,-1};
        int first= binarySearchFirst(nums, 0, n-1, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = binarySearchLast(nums, first, n-1, target);
        return new int[]{first, last};
        
}
}
