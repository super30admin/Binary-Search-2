public class FirstLastSortedArray {

    public static void main(String[] args)
    {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8,8,9,7,10,10,11,11,12};
        int target = 8;
        int result[] = searchRange(nums, target);
        System.out.println("result: " + result[0] + " " + result[1]);
    }
    //Time Complexity  : O(log n)
    //Space Complexity : O(n)
    public static int[] searchRange(int[] nums, int target) {
        // 2 binary searches
        // 1 for finding the starting index
        // 2nd for finding the last index 

        int[] result = new int[2];

        int low = 0;
        int high = nums.length - 1;

        result[0] = -1;
        result[1] = -1;

        int first = binarySearch(nums,low,high,target);
        if(first == -1) return result;

        int second = binarySearchLast(nums,first,high,target);

        result[0] = first;
        result[1] = second;
        
        return result;
    }

    public static int binarySearch(int[] nums,int low, int high, int target)
    {
        while(low <= high) 
        {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
            {
                if(mid ==0 || nums[mid] > nums[mid-1])
                {
                    return mid;
                }
                else 
                {
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target)
            {
                low = mid + 1; 
            }
            else
            {
               high = mid - 1;
            }
        }

    return -1;

    }

    public static int binarySearchLast(int[] nums,int low, int high, int target)
    {
        while(low <= high) 
        {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
            {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                else 
                {
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target)
            {
                low = mid + 1; 
            }
            else
            {
               high = mid - 1;
            }
        }

    return -1;

    }
}