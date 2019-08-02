#include<iostream>
using namespace std;


//binarySearch(int arr[],int left,int right);


int binarySearch(int arr[], int left, int right,int target)    //Binary search implemented.
{
    int min = INT_MAX;
    if (left<=right) {
        int mid = left + (right - left) / 2;

    if(arr[mid]==target)			//CASE 1 : If the middle element is equal to target.
    {
        if(arr[mid]==arr[mid-1])		// CASE 1.1. Example ; [8,8,9] Target 8. Middle = Middle-1 
        {
            cout<<"["<<mid-1<<","<<mid<<"]";
            return mid;
        }
        if(arr[mid]==arr[mid+1])		// CASE 1.2: Example ; [8,9,9] Target 9. Middle = Middle+1
        {
            cout<<"["<<mid<<","<<mid+1<<"]"; return mid;
        }
    }
    if(arr[mid]>target)			// If middle is greater than target. Search Left part. Example : [5,5,6,8,9,10,11]. Target 5
        {
        return binarySearch(arr,left,mid-1,target);
    }
    if(arr[mid]<target)			// IF middle is lesser than target. Search right part. Example :[ 5,6,8,9,9,10]. Target 9.
    {
        return binarySearch(arr,mid+1,right,target);
    }


    }

    cout<<"not found"; return 0;
}

int main()
{
    int arr[] = {5,7,7,8,8,10};
    int size= sizeof(arr)/sizeof(arr[0]);
    int target = 8;

    binarySearch(arr,0,size-1,target);

    return 0;
}