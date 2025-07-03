class Solution {
   
    public int[] searchRange(int[] nums, int target) {
        int first=findfirst(nums,target);
        if(first==-1){
            return new int[] {-1,-1};
        }
        int last=findlast(nums,target);
        return new int[]{first,last};
    }

    private int findfirst(int[] nums,int target){
        int s=0,e=nums.length-1;
        while(s<=e){
           int m=s+(e-s)/2;
            if(target==nums[m]){
                if(m==0 || nums[m-1]!=target){
                    return m;
                }
                else{
                    e=m-1;
                }
            }
            else if(target>nums[m]){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
          return -1;
    }

    private int findlast(int[] nums,int target){
        int index=-1, s=0, e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]==target){
                if(m==nums.length-1 || nums[m+1]!=target){
                    return m;
                }
               else{
                s=m+1;
               }
            }
            else if(target>nums[m]){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
return -1;
    }
}
