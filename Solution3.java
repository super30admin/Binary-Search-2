//Finding Peak Element
//Time Complexity: O(log n)
//Space Complexity: O(1)
//Solved in leetcode: Yes
/*
Approach: compare the mid element with the neighbour elements and move the search space towards the largest neighbour, as it is guaranteed to find the peak element
 */
import java.util.Scanner;

public class Solution3 {
    public int findPeak(int[] arr){
        int low = 0;
        int high = arr.length-1;
        if (arr.length == 1) return 0; // if array length is 1 then that is the peak
        while (low<=high){
            int mid = low+(high-low)/2;
            // if mid is leftmost compare with right neighbour
            // if mid is rightmost element compare with its left neighbour to check if it is the peak
            if ((mid==0 && arr[mid]>arr[mid+1]) || (mid==arr.length-1 && arr[mid]>arr[mid-1])){
                return mid;
            }
            // check if the mid ele is greater than its neighbours and maintain checks for the mid-index, so that it exists in the array range
            if (mid>0 && arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1] && mid<arr.length){
                return mid;
            } else if(mid>0 && arr[mid-1]>arr[mid]){ //move the search space towards largest neighbour of mid
                high = mid-1; //if left neighbour is largest
            } else {
                low = mid+1; //if right neighbour is largest
            }

        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        Solution3 sol = new Solution3();
        sol.findPeak(arr);
        for (int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
}
