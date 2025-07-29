// This problem involves doing two binary searches one for searching left index of the contiguous array and another for searching right index
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = searchLeftIndex(nums, target, 0, nums.length-1);
        int j = i!=-1?searchRightIndex(nums, target, 0, nums.length-1):-1;
        int[] response = new int[2];
        response[0] = i;
        response[1] = j;
        return response;
    }

    public int searchLeftIndex(int[] nums, int target, int i, int j) {
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]==target) {
                // This is the breaking condition to check if the index points to the left index where the element differs by the previous one
                if(mid==0 || nums[mid-1]!=nums[mid]) return mid;
                j=mid-1;
            } else if(nums[mid]>target) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return -1;
    }

    public int searchRightIndex(int[] nums, int target, int i, int j) {
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]==target) {
                // This is the breaking condition to check if the index points to the right index where the element differs by the next one
                if(mid==nums.length-1 || nums[mid+1]!=nums[mid]) return mid;
                i=mid+1;
            } else if(nums[mid]>target) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return -1;
    }
}
