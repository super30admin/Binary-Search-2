// Time Complexity:O(log n)+O (log m)
// Space Complexity: O(n)
// this problem was solved on leet code.
// Approach: use binary search for 2 times one to fing the first element and the other to fingd the last.

class Solution {
    private int binarysearchfirst(int[]arr,int low,int high, int target){
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]==target){
                    if(mid==0 || arr[mid]>arr[mid-1]){
                       return mid;
                    }else{
                        high =mid-1;
                    }

                }else if(arr[mid]>target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                } 
            }
            return -1;
        }
        private int binarysearchlast(int[]arr,int low,int high, int target){
            while(low<=high){
                int n=arr.length;
                int mid=low+(high-low)/2;
                if(arr[mid]==target){
                    if(mid==n-1 || arr[mid]<arr[mid+1]){
                       return mid;
                    }else{
                         low=mid+1;
                    }

                }else if(arr[mid]<target){
                    low=mid+1;
                }
                else high=mid-1;
            }
            return -1;
        }
    public int[] searchRange(int[] nums, int target) {         
        int low=0; int n=nums.length;int high=n-1;
        if(nums==null || n==0) return new int[]{-1,-1};
        if(nums[0]>target && nums[high]<target) return new int[]{-1,-1};    

        int first= binarysearchfirst( nums,0,n-1,target);
           if(first==-1) return new int[] {-1,-1};
         int last= binarysearchlast(nums,first,n-1,target);
            return new int[] {first,last};
        }

}