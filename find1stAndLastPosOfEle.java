public class find1stAndLastPosOfEle {
    /** Time Complexity : O(log n)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No


     Your code here along with comments explaining your approach in three sentences only **/
    private int findFirstEle(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==target){
                if(mid==0 || arr[mid]>arr[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(arr[mid]>=target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return -1;
    }

    private int findLastEle(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==target){
                if(mid==arr.length-1 || arr[mid]<arr[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(arr[mid]<target){
                low = mid+1;

            }else{
                high = mid-1;
            }

        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        if(nums[0]>target || nums[n-1]<target){
            return new int[]{-1,-1};
        }

        int left = findFirstEle(nums, 0, n-1, target);
        int right = findLastEle(nums, left, n-1, target );
        int ans[] = {left, right};
        return ans;
    }
}
