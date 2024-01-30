//time complexity: O(log(m) + log(n)); worst case log(n) takes over
//space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : condition check

//Sorted array has been given : Increasing number array and duplicates are allowed
//find range
//find an element
//modular code

import java.util.Scanner;
import java.util.Arrays;

public class FirstLastIndex {
    
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        if(nums == null || nums.length == 0) return arr;  
        int n = nums.length;     
        if(target < nums[0] || nums[n-1] < target) return arr;
        int first = binarySearchFirst(nums, 0, nums.length-1, target);
        if(first == -1)
        { 
            return arr;
        }else{
            int last = binarySearchLast(nums, first, nums.length-1, target);
            arr[0] = first;
            arr[1] = last;            
        }
        return arr;
    }

    public int binarySearchFirst(int[] nums, int low, int high, int target) {
            
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid] > nums[mid-1]){
                        return mid;
                    }else{
                        high = mid -1;
                    }
                }else if(nums[mid] > target){
                    high = mid -1;
                } else{
                    low = mid +1;
                }
            }
        return -1;
    }

    public int binarySearchLast(int[] nums, int low, int high, int target){
            int n = nums.length; 
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid == n-1 || nums[mid] < nums[mid+1]){
                        return mid;
                    }else {
                        low = mid+1;
                    }
                }else if(nums[mid] > target){
                    high = mid -1;
                } else{
                    low = mid +1;
                }
            }

        return -1;
    }

    public static void main (String[] args){
        FirstLastIndex obj = new FirstLastIndex();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter size of an array: ");
        int size = sc.nextInt(); // Assuming user only enter positive number here
        int[] arr = new int[size];
        System.out.println("Please enter elements of array now: ");
        for(int i=0;i<size;i++) {
            arr[i] = sc.nextInt();
            
        }
        System.out.println("Inputed array : " + Arrays.toString(arr));
        System.out.println("Please enter the target element : ");
        int target = sc.nextInt();
        int[] range = obj.searchRange(arr, target);
        System.out.println("Start and last index of target (" +target+") ==> " + Arrays.toString(range));
    }
}