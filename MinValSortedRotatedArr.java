class MinValSortedRotatedArr {
    //Initially array was sorted before rotation.
    //After rotation element from starting goes to behind that means at least one side of array remains sorted.
    //TC will be O(log N), so will use Binary search to find the min val element in the array
    //SC will be O(1), as there is only on array.
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){ //If array is empty the there will be no min value element.
            return -1;
        }
        int low=0;
        int high=nums.length-1;

        while(low<=high){

            if(nums[low]<nums[high]){   //When array is already sorted.
                return nums[low];
            }

            int mid= low+(high-low)/2;  //To prevent integer overflow

            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]))     //mid element is smaller than adjacent left and right value and out of index condn.
            {
                return nums[mid];       //return mid value
            }
            if((nums[low]<=nums[mid])){ //Condn to check if left side is sorted.
                low=mid+1;  //Least value lies on the unsorted part of the array check in right side.
            }
            else{
                high=mid-1;
            }
        }
        return 45678;   //some random fxn, if array exists then there will be an min value.
    }


    public static void main(String[] args){
        MinValSortedRotatedArr obj = new MinValSortedRotatedArr();
        int[] nums=  {4,7,8,9,1,2,3};
        int[] nums2= {23,45,67,89,9,13};
        System.out.println(obj.findMin(nums));
        System.out.println(obj.findMin(nums2));
    }
}