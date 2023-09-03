class FirstLastOccurrence {
    //It is given array is sorted.
    //Need to find out first and last occurrence of the element.
    //TC will be O(log N) that means Binary Search
    //Space Complexity will be O(1)
    public int[] searchRange(int[] nums, int target) {

        if (nums==null || nums.length==0){ //Array is empty
            return new int[] {-1,-1};
        }

        int first = binaryFirstSearch(nums,target); //Calling fxn to get fisrt Occurence of number

        if(first == -1){  //Condn to check if there is no occurence
            return new int[] {-1,-1};  //this means element is not present and return without calling last occurence fxn.
        }

        int last = binaryLastSearch(nums,target);// calling fxn to get last occurrence of number.
        return new int[] {first,last};  //returning first and last occurencce of elements.

    }

    private int binaryFirstSearch(int[] nums,int target){
        int low= 0;
        int high= nums.length-1;

        while(low<=high){
            int mid= low+(high-low)/2; //to prevent integer overflow
            if(nums[mid]==target){  //if target is at mid
                if((mid==0) || (nums[mid-1]!=nums[mid])){ //condn to check if mid is the first occurrence and also to prevent index out of vound error if mid is already at low.
                    return mid;
                }
                high=mid-1; //If mid is not the first occurence then check on left hand side and change high.
            }
            else if(nums[mid]>=target){  //If target is less than mid then shift to left side.
                high=mid-1;
            }
            else{           //If Target is higher than mid element then shift to right side.
                low=mid+1;
            }
        }
        return -1;     //Not found then return -1
    }



    private int binaryLastSearch(int[] nums, int target){
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;           //To prevent integer overflow.
            if (nums[mid]==target){             //If mid element is equal to target
                if((mid==nums.length-1) || (nums[mid]!=nums[mid+1])){  //condn to check if mid is the last occurrence
                    return mid;
                }
                low=mid+1;      //if mid is not last occurrence then shift to right side.
            }
            else if(target>=nums[mid]){     //If target is greater than mid then shift to right
                low=mid+1;
            }
            else{
                high =mid-1;            //if smaller the shift to left side.
            }
        }
        return -1;                  //Not found return -1.
    }


    public static void main(String[] args) {
        FirstLastOccurrence obj = new FirstLastOccurrence();
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7};
        int target = 4;
        int[] result = obj.searchRange(arr, target);

        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First occurrence: " + result[0]);
            System.out.println("Last occurrence: " + result[1]);
        }
    }

}