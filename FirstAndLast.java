//TC Ologn
//sc O(1)

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int f= firstIndex(low,high,nums, target);
        int s=lastIndex(low,high,nums,target);
        System.out.println(f+" "+s);
        return new int[]{f,s};
    }

    private static int lastIndex(int f, int high, int[] a,int target) {
        while(f<=high){
            int mid=f+(high-f)/2;
            if (a[mid] == target) {
                if(mid==high || a[mid+1]>target ){
                    return mid;
                }
                else{
                    f=mid+1;
                }
            }
            else if(a[mid]>target){
                high=mid-1;
            }
            else{
                f=mid+1;
            }
        }
        return -1;
    }

    private static int firstIndex(int low,int high,int[] a,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==target){
                if(mid==low || a[mid-1]<target){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }


            else if(a[mid]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }

        }
        return -1;
    }
}