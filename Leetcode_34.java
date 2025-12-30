///Way 1
//Linear search
//TC: O(n); SC: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1,end=-1;

        int j=0;

        while(j<nums.length && nums[j]!=target){
            j+=1;
        }

        if(j==nums.length){
            return new int[]{-1,-1};
        }else if(j==nums.length-1){
            return new int[]{nums.length-1,nums.length-1};
        }else{
            start=j;

            end=j+1;

            while(end<nums.length && nums[end]==target){
                end+=1;
            }
            end=end-1;
        }

        return new int[]{start,end};
        
    }
}

//Way 2:
//Perform binary search on the given nums to find target. From low to the target index, perform binary saerch to find start index. From the same target index to high, perform another binary search to find end index.
//TC: log n; SC: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
       int n=nums.length;

       int low=0,high=n-1;
       int start=-1,end=-1;

       while(low<=high){
        int mid=low+(high-low)/2;

        if(nums[mid]==target){
            start=findFirst(nums,target,low,mid);
            end=findLast(nums,target,mid,high);
            break;
        }else if(nums[mid]<target){
            low=mid+1;
        }else{
            high=mid-1;
        }
       }

       return new int[]{start,end};
        
    }

    private int findFirst(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }

    private int findLast(int[] nums,int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return low-1;
    }
}
