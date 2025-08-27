package sree;

//Here were are running two binary searches to get the first and last index of the target element.
public class FLIndex {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int first= binarySearch1(nums,target,low,high);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int last= binarySearch2(nums,target,first,high);
        return new int[]{first,last};
        
    }

    public int binarySearch1(int [] nums, int target, int low, int high){
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                else{
                    high= mid-1;
                }
            }
            else if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    public int binarySearch2(int [] nums, int target, int low, int high){
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==(nums.length-1) || nums[mid+1]!=target){
                    return mid;
                }
                else{
                    low= mid+1;
                }
            }
            else if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}