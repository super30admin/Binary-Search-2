//reference approach 3 solution of leetcode 162. Find Peak Element 
class SearchPeak{
  static int findPeak(int[] array) {
	  int l=0; int r= array.length-1;
	  while(l<r) {
		  int mid = l+(r-l)/2;
		  if(array[mid]>array[mid+1])  r=mid;
		  else l =mid+1;
	  }
	  
	  return l;
  }
}


public class FindPeak {
	
	public static void main(String[] args) {
		SearchPeak searchPeak = new SearchPeak();
		int[] input = {4,5,6,7,0,1,2};
		for (int i =0 ; i<input.length;i++) {
			System.out.println("input array  is ="+input[i]);
		}

		int min = SearchPeak.findPeak(input);
		
		System.out.println("Index of Peak element is="+min);
	}
}
