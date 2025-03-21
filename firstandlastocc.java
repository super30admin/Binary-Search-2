//Time Complexity o(logN)

public class firstandlastocc {

        public int[] searchRange(int[] nums, int target) {
          int firstele =  findFirst(nums, target);
         int lastele =findLast( nums, target);
           return new int[]{firstele , lastele};
        }
    
    
         private int findFirst(int[] nums, int target){
            int left =0; int right =nums.length-1;
            int n=nums.length;
            int first = -1;
    
            while(left<=right){
                int mid=left+(right-left)/2;
    
                if(nums[mid]==target){
                 first=mid;
                 right=mid-1;
                }
                else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
    
            }
            return first;
         }
          private int findLast(int[] nums, int target){
            int left =0;int right =nums.length-1;int n=nums.length; int last = -1;
    
            while(left<=right){
                int mid=left+(right-left)/2;
    
                if(nums[mid]==target){
                 last=mid;
                 left=mid+1;
                }
                else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
    
            }
            return last;
         }
    }

s
