// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class FindFirstAndLastIndex0fTarget {
    public int[] searchRange(int[] arr, int target) {
        if(arr == null || arr.length == 0) return new int[] {-1,-1};
        int l = 0;
        int n = arr.length-1;
        int h = n;
        if(arr[l] > target || arr[h] < target) return new int[] {-1,-1};
        //left side Binary search
        int leftIndex = SearchLeftIndex(arr,l,h,target);
        if(leftIndex == -1) return new int[] {-1,-1};
        int rightIndex = SearchRightIndex(arr, l, n, target);
        return new int[] {leftIndex,rightIndex};
    }

    private int SearchLeftIndex(int[] arr,int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid] == target){
                if(mid==l || arr[mid] > arr[mid-1]){
                    return mid;
                }
                else{
                    h=mid-1;
                }
            }
            else if(arr[mid] > target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    private int SearchRightIndex(int[] arr, int l, int h, int target){
        while(l<=h) {
            int mid = l + (h-l)/2;
            if(arr[mid] == target){
                if(mid==h || arr[mid] < arr[mid+1])
                {
                    return mid;
                }
                else{
                    l = mid+1;
                }
            }
            else if (arr[mid] > target){
                h=mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;

    }
}