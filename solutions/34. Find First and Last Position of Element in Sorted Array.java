//Time complexity: log(n)
// here we are first find the target element in the entire array then from there we are first moving in the left side for //finding the first occurance of the target, then we are moving towards right side for finding the last occurance of the //target.
//What to do while while moving towards left: again apply binary search and find the first occurance
//What to do while while moving towards right: again apply binary search and find the last occurance(this binary search //we need to start from first occurance of target till end of the array).
​
​
class Solution {
  public static int[] searchRange(int[] nums, int target) {
​
        int low=0;
        int high=nums.length-1;
        int[] ans=new int[2];
​
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }else{
            int firstmin=firstmin(nums,low,high,target);
​
            if(firstmin==-1){
                return new int[]{-1,-1};
            }else{
                int lastmin=lastmin(nums,firstmin,high,target);
​
                return new int[]{firstmin,lastmin};
            }
        }
    }
​
    public static int firstmin(int[] arr, int low, int high, int target){
        while (low<=high){
            int mid=low+(high-low)/2;
​
            if(arr[mid] == target) {
                if (mid == 0) {
                    return mid;
                }else {
                    if (arr[mid-1]<target) {
                        return mid;
                    }else{
                        high=mid-1;
                    }
                }
            }else if (arr[mid]<target) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
​
    public static int lastmin(int[] arr, int low, int high, int target){
        while (low<=high){
            int mid=low+(high-low)/2;
​
            if (arr[mid] == target) {
                if (mid== arr.length-1 || (mid<arr.length-1 && arr[mid+1]>target)) {
                    return mid;
                }else{
                    low=mid+1;
                }
            }else if (arr[mid]<target) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
}
