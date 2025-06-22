// Time Complexity
// bsfirst(nums, target) → Binary search to find first occurrence
// bslast(nums, target) → Binary search to find last occurrence
// Each binary search runs in O(log n) time where n is the size of the input array.
// Time Complexity = O(log n) + O(log n) = O(log n)


// Space Complexity = O(1)



class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0) //checks for the edge case
        {
            return new int[] {-1,-1};
        }
        int first = bsfirst(nums, target);
        if(first == -1) //if there is no sno element in an array no need to check for last position
        {
            return new int[] {-1,-1};
        }
        int second = bslast(nums, target);
        return new int[] {first, second};
    }
    private int bsfirst(int[] n, int target)
    {
        int start = 0;
        int end = n.length-1;
        while(start<=end)
        {
            int mid = start + (end- start)/2; //to prevent integer overflow
            if( n[mid] == target)
            {
                if(mid ==0 || n[mid-1]!=n[mid]) //checking if there is any previous start for the element 
                {
                    return mid;
                }
                else
                {
                    end = mid-1;
                }
            }
            else if(target> n[mid]) //if the target is present right half of the array
            {
                start = mid+1;
            }
            else //left half
            {
                end = mid-1;
            }
            
        }
        return -1;
    }


    private int bslast(int[] n, int target)

        {
            int start = 0;
            int end = n.length-1;
            while(start<=end)
            {
                int mid = start + (end- start)/2; //to prevent integer overflow
                if( n[mid] == target)
                {
                    if((mid == n.length-1) || (n[mid+1] != n[mid]))
                    {
                        return mid;
                    }
                    else
                    {
                        start = mid +1;
                    }
                }
                else if(target> n[mid]) //if the target is present right half of the array
                {
                    start = mid+1;
                }
                else //left half
                {
                    end = mid-1;
                }
                
            }
            return -1;
        }
}

public class FirstAndLast {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = sol.searchRange(nums, target);
        System.out.println("First and last position of " + target + ": [" + result[0] + ", " + result[1] + "]");

        // Example 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;

        int[] result2 = sol.searchRange(nums2, target2);
        System.out.println("First and last position of " + target2 + ": [" + result2[0] + ", " + result2[1] + "]");

        // Example 3
        int[] nums3 = {};
        int target3 = 0;

        int[] result3 = sol.searchRange(nums3, target3);
        System.out.println("First and last position of " + target3 + ": [" + result3[0] + ", " + result3[1] + "]");
    }
}
