// Time Complexity :O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {

public int[] searchRange(int[] nums, int target) { 
  if( nums == null || nums.length == 0) {
       return new int[]{-1, -1}; 
     }

  int l = 0;
  int n = nums.length;
  int r = n -1;
 
  if (nums[0] > target || nums[n-1] < target){
     return new int[]{-1,-1}; 
  }

  int first  = firstBinarysearch(nums, l,r,target);
  if (first == -1)
  {
        return new int[]{-1,-1}; 
 
  }
  int last  = lastBinarysearch(nums,first,r,target);

  return new int[]{first,last};

    }


public int firstBinarysearch(int[] nums,int l ,int r,int target){
while(l<=r){
int mid = l + (r-l)/2;
if (nums[mid] == target){
    if( mid == 0 || nums[mid] > nums[mid-1])  
    return mid;
    else 
    r = mid-1;
}
 else if (nums[mid]>target){
    r = mid -1;
 }
 else l = mid+1;
}
return -1;
}


public int lastBinarysearch(int[] nums,int l ,int r,int target){
while(l<=r){
int mid = l + (r-l)/2;
if (nums[mid] == target){
    if( mid == nums.length-1 || nums[mid] < nums[mid+1]) { 
    return mid;
    }
    else{
    l = mid + 1;
    }
}
 else if (nums[mid]>target){
    r = mid -1;

 }
 else {l = mid+1;}
}
return -1;
}


}
