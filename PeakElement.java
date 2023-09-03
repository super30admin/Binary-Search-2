
    class PeakElement {
        //Return index of element which is greater than both left and right neighbors.
        //TC O(log n), will do binary search.
        //SC O(1), there is only one array.

        public int findPeakElement(int[] nums) {

            int low=0;
            int high=nums.length-1;

            while(low<=high){
                int mid= low+(high-low)/2;  //To prevent integer overflow.

                if((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1 || nums[mid]>nums[mid+1])){ //Condn to check the adjacent left and right element are smaller.
                    return mid;
                }
                if (mid==0||nums[mid]>nums[mid-1]){  //If mid-1 is smaller then move to right side
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            return -1; //Not found
        }

        public static void main(String[] args){
            PeakElement obj = new PeakElement();
            int[] nums={1,2,1,3,5,6,4};
            System.out.println(obj.findPeakElement(nums));
        }
    }
