class FindMin {
    public static int findMin(int arr[],int low,int high) 
  { 
    
      if (low==high) return arr[low]; 

      int mid = low + (high - low)/2; 

      if (mid < high && arr[mid+1] < arr[mid]) 
          return arr[mid+1]; 

      if (mid > low && arr[mid] < arr[mid - 1]) 
          return arr[mid]; 

      if (arr[high] > arr[mid]) {
          return findMin(arr, low, mid-1); 
      }
      return findMin(arr, mid+1, high);
  }  
  
  public static void main (String[] args) {
      int nums[]={1,2,3,4};
      int min =findMin(nums,0,nums.length -1);
      System.out.println(min);
      
  }
}