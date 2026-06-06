//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2]
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0

public class min_element {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            if(arr[low]<=arr[high]){
                System.out.print(arr[low]);
                return;
            }
            int mid = low+(high-low)/2;
            if(mid>0 && arr[mid]<arr[mid-1]){
                System.out.print(arr[mid]);
                return;
            }
            else if(arr[low]<=arr[mid]){
                low=mid+1;
            }
            else{
                high = mid - 1;
            }
            
    }
    
}}
