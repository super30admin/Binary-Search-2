public class FirstAndLastOccurrencesInSortedArray {
     public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int firstOccurrences = getFirstOccurrence(nums , low , high , target);
        if(firstOccurrences == -1)
            return new int[]{-1,-1};
        
        int lastOccurrences = getLastOccurrence(nums , firstOccurrences , high , target);

        return new int[]{firstOccurrences , lastOccurrences};
        
    }

    private static int getFirstOccurrence(int[] nums , int low , int high , int target) {
       
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == 0 || (nums[mid] != nums[mid-1])) 
                    return mid;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    private static int getLastOccurrence(int[] nums , int low , int high , int target) {
       
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == nums.length-1 || (nums[mid] != nums[mid+1])) 
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(arr , target);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }
}