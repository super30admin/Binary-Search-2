//Finding minimum in rotated sorted array
//Time Complexity: O(log n)
//Space Complexity:O(1)
//Solved in Leetcode: Yes
/*
Approach:
Used binary search, set the search space towards unsorted array, ignoring sorted side of the array.
as there is always a chance to find the min element in unsorted array.
our search key will be the mid element that is less than its previous element
 */
import java.util.Scanner;
public class Solution2 {

    public int findMinElement(int[] arr, int low, int high){

        while (low<=high) {
            if (arr[low]<=arr[high]) return arr[low]; //if the array is sorted return left most element
            int mid = low+(high-low)/2;
            if (mid>0 && arr[mid]<arr[mid-1]){  // our search key is mid element less than its prev element
                return arr[mid];
            } else if (arr[low]<=arr[mid]){  // ignore sorted array and move pointer towards unsorted side
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Solution2 sol = new Solution2();

        int low = 0;
        int high = n-1;

        int res = sol.findMinElement(arr, low, high);
        System.out.println(res);

    }
}
