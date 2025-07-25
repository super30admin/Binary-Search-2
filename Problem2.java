import java.util.*;
public class Problem2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int l=0,h=nums.length-1,ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[l]<=nums[mid]){
                ans=Math.min(ans,nums[l]);
                l=mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                h=mid-1;
            }
        }
        return ans;
    }
}