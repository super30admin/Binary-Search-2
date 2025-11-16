//Problem: Finding first and last position of an element in a sorted array
//Time Complexity: O(log n)
//Space Complexity: O(1)
//Solved in Leetcode: Yes

/*
Approach:
Did regular binary search to find the target element,
to find the first position, check if the curr mid ele is greater than prev ele, if yes that means we found the first position
if not we set the range from low to that prev element. first position must be somewhere in that range, perform regular
binary search till we find the first pos.

same with last element,
check if the element is smaller than next element, if not move low to next element (search in the range of mid+1 to high)

edge cases if element found at mid and mid is 0 that is first pos and vise versa.
 */

import java.util.Scanner;

public class Solution1 {

    //get first position of target element
    public int getFirstPos(int[] arr,int low, int high, int target){
        while(low<=high) {
            int mid = low+(high-low)/2;
            if (arr[mid] == target){
                if (mid == 0) return 0; //if target is at 0th pos
                if (arr[mid-1]<arr[mid]){
                    return mid; // if the mid ele found is greater than prev ele, that is the 1st pos
                } else {
                    high = mid-1;  // if not move set high to mid-1
                }
            } else if (arr[mid]>target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    //Finding last position of target element
    public int getLastPos(int[] arr, int low, int high, int target){
        while (low<=high){
            int mid = low+(high-low)/2;
            if (target == arr[mid]){
                if (mid == high) return high; //if last ele is mid
                if (arr[mid]<arr[mid+1]){
                    return mid;  //if mid is less than next ele, last pos found
                } else {
                    low = mid+1; //if not change low position
                }
            } else if(arr[mid]>target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] getPositions(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        if (arr.length == 0) return new int[]{-1,-1};
        if (target<arr[low] || target>arr[high]) return new int[]{-1,-1}; //if target element is not in the range
        //check for the first occurrence
        int firstPos = getFirstPos(arr, low, high, target);
        int lastPos = getLastPos(arr, firstPos, high, target);

        return new int[]{firstPos, lastPos};

    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        Solution1 sol = new Solution1();

        int[] result = sol.getPositions(arr, n , target);
        System.out.println(result[0]+" "+result[1]);

    }


}

/*
sample text case:
6
5
7
7
8
8
10
8
 */