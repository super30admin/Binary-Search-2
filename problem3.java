import java.util.*;
public class Problem3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[n-1]>nums[n-2])
            return n-1;
        int l=1,h=nums.length-2;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]<nums[mid+1])
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}