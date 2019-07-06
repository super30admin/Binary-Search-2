
public class Day4Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int nums[] =  {3,4,5,1,2};



	        Day4Solution2BF s1 = new Day4Solution2BF();

	        System.out.println( nums[s1.search(nums)]);

	}

}

class Day4Solution2BF{

    int search(int[] nums){

    	// the brute force approach would be return element which is smaller than previous element.

    	int pivot =0;
    	int i=1;

    	for(i=1;i<nums.length;i++) {
    		if(pivot<=nums.length) {
	    		if(nums[i]<nums[pivot]) {
	    			return i;
	    		}
    		}
    		pivot++;
    	}
   return 0;
}
}



/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0*/


class Day4Solution2{

    int[] search(int[] nums, int target){

        int res[] = new int[2];

        int l = 0;
        int r = nums.length - 1; // {5,7,7,8,8,10};

        int mid=0;
        while(l<=r){

            mid = l +(r-l)/2 ;
            if(nums[mid] == target){    // The problem here we once we find the target either it will be high position or the low position
            							// this can be handled with following if and else condion.
                if(nums[mid+1] ==  target) {
            	res[0] = mid;
                res[1] = mid+1;
                }else {
                	res[0] = mid-1;
                    res[1] = mid;
                }

                return res;

             }
            else if(target<= nums[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

}
