/*
First and Last index of an element
approach is same as the lecture

time: O(log N)
space: O(1)

public class Sample {

    public static int[] searchRange(int[] nums, int target) {
        int l=0, h=nums.length-1;
        int pair[] = {-1,-1};

        while(l<=h) {
            int m = l+(h-l)/2;

            if(nums[m]==target){
                if(m==0 || nums[m]>nums[m-1] ) {
                    pair[0] = m;
                    pair[1] = bst(nums, m+1, nums.length, target);
                    break;
                }
                else h=m-1;

            }
            else if(target<nums[m]) h = m-1;
            else
                l = m+1;
        }
        return pair;
    }

    static int bst(int[] nums, int l, int h, int target){
        while(l<=h) {
            int m = l+(h-l)/2;

            if(nums[m]==target){
                if (m==nums.length-1 || nums[m]<nums[m+1]){
                    return m;
                }
                else l=m+1;
            }
            else if(target<nums[m]) h = m-1;
            else
                l = m+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("pair "+searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
}

Find peak element in an array
approach: same as instructed
time: O(log N)
space: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int l=0, h = nums.length-1;
        if(nums.length==0) return -1;

        while(l<=h) {
            int m = l+(h-l)/2;

            if((m==0 || nums[m]>nums[m-1]) && (m==nums.length-1 || nums[m]>nums[m+1])) return m;
            else if(m>0 && nums[m]<nums[m-1]){
                h = m-1;
            }
            else l = m+1;
        }
        return -1;
    }

}


Find minimum element in rotated sorted array
instructor's approach
time: O(log N)
space: O(1)
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        int l=0, h=nums.length-1;


        while(l<=h) {
            if(nums[l]<nums[h]) return nums[l];

            int m = l+(h-l)/2;

            if((m==0||nums[m]<nums[m-1]) && (m==nums.length-1||nums[m]<nums[m+1])) return nums[m];
            else if(nums[m]>=nums[l]) l = m+1;
            else h=m-1;
        }
        return -1;
    }

}

*/
