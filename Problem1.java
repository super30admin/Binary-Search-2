import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        int ans[]=new int[2];
        ans[0]=binarySearch(target,arr,true);
        ans[1]=binarySearch(target,arr,false);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int binarySearch(int target, int[] arr, boolean f) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (f) 
                    high = mid - 1;
                else 
                    low = mid + 1;
            } else if (arr[mid] < target) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return result;
    }
}