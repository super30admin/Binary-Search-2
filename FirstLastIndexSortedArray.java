/**
 * Complexity: findingLeft + findingRight
 * => log n + log n
 * => log n
 */
public class FirstLastIndexSortedArray {
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        System.out.println("First: " + result[0]);
        System.out.println("Last: " + result[1]);
        return result;
    }
	
	//Finding the left most element with the value equal to target
	int findLeft(int[] nums, int target) {
		int low = 0, high = nums.length-1, mid ;
        while(low <= high) {
        	System.out.println("high: "+ high);
        		mid = low+(high-low)/2;
        		System.out.println("mid: "+ mid);
        		if(nums[mid] == target) {
        			//Find the left most element equal to target
        			if(low == mid || nums[mid-1] < target) {
        				return mid;
        			} else {
        				high = mid-1;
        			}
        		} else if(nums[mid] < target) {
        			low = mid+1;
        		} else {
        			high = mid-1;
        		}
        }
        return -1;
	}
	
	//Finding the right most element with the value equal to target
	int findRight(int[] nums, int target) {
		int low = 0, high = nums.length-1, mid ;
        while(low <= high) {
        		mid = low+(high-low)/2;
        		if(nums[mid] == target) {
        			//Find the right most element equal to target
        			if(high == mid || nums[mid+1] > target) {
        				return mid;
        			} else {
        				low = mid+1;
        			}
        		} else if(nums[mid] < target) {
        			low = mid+1;
        		} else {
        			high = mid-1;
        		}
        }
        return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstLastIndexSortedArray s = new FirstLastIndexSortedArray();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		s.searchRange(nums, target);
	}

}
