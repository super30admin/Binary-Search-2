#include<iostream>
using namespace std;





int binarySearch(int arr[], int left, int right)    //Binary search implemented.
{
    int min = INT_MAX;
    int mid = left + (right - left) / 2;
    if (left<=right) {
        if(left==right)         //if only one element in the array. CASE 1.
        {
            cout<<left; return left;
        }

        
        if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])          //CASE 2: if middle is > left and smaller than right. Search the right part. 
                                                                // Example Case : [4,6,8,9,1,2]. Middle is 8. Greater than 6, Less than 9. Search Right.
        {   return binarySearch(arr, mid + 1, right);

        }

        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])      //CASE 3 : if middle element is bigger than left side and also right side, 
                                                                // then the next element is the smallest.
                                                                // Example of this case : [4,5,6,7,0,1,2]. Middle 7 is > 6 and also >0. hence min = 0.
        {
            min=arr[mid+1]; cout<<min; return min;      //return minimum value. 
        }

        if(arr[mid<arr[mid-1]] && arr[mid]<arr[mid+1])      //CASE 4 : If middle is less than left and also smaller than right, then it is the minimum element. 
                                                            // Example of this case : [ 4,5,0,1,2] . Middle is 0. Smaller than both left and right.
        {
            min=arr[mid];  cout<<min; return min;
        }
        


    }

    cout<<"not found"; return min;
}

int main()
{
    int arr[] = {4,5,6,7,0,1,2};
    int size= sizeof(arr)/sizeof(arr[0]);
    int min = INT_MAX;

    binarySearch(arr,0,size-1);

    return 0;
}


