#include<iostream>
using namespace std;


//binarySearch(int arr[],int left,int right);


int binarySearch(int arr[], int left, int right)    //Binary search implemented.
{

    if (left<=right) {
        int mid = left + (right - left) / 2;


        if (arr[mid]>arr[mid+1]&& arr[mid]>arr[mid-1]) {		// Check if Middle is greater than both left and right side.
            cout << "Found Peak Element " ; cout<<arr[mid];
            return arr[mid];
        }
         if(arr[mid-1]<arr[mid])	// Search left side.
        return binarySearch(arr, left, mid - 1);
        if(arr[mid+1]>arr[mid])
            return binarySearch(arr, mid + 1, right);// Search right side.


        }

cout<<"not found"; return 0;
    }

int main()
{
    int arr[10] = {1,2,1,3,5,6,4};
    int size= sizeof(arr)/sizeof(arr[0]);

binarySearch(arr,0,size-1);

    return 0;
}