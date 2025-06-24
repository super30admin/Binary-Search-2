// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// I used binary search to find the first and last positions of the target in the sorted array. 
// The first search checks if the current match is the first occurrence by looking at the previous element.
// The second search does the same for the last occurrence by checking the next element.



import java.util.Arrays;

class firstandlast{
    public int[] searchRange(int[] nums, int target){
        if(nums==null || nums.length==0){
            return new int[]{-1, -1};
        }

        int first = firstBinSearch(nums, target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int second = LastBinSearch(nums, target);
        return new int[] {first, second};

    }

    private int firstBinSearch(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=nums[mid]){
                    return mid;
                }
                high=mid-1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return -1;
    }

    private int LastBinSearch(int[] nums, int target){
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=nums[mid]){
                    return mid;
                }
                low=mid+1;

            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        firstandlast obj = new firstandlast();
        int[] result = obj.searchRange(nums, target);
        System.out.println(Arrays.toString(result));

       
    }
}