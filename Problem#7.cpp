// C++ program to find first and last occurances of 
// a number in a given sorted array 
#include <iostream> 
using namespace std; 
  
/* if x is present in arr[] then returns the index of  
FIRST occurrence of x in arr[0..n-1], otherwise  
returns -1 */
int first(int arr[], int x, int n) 
{ 
    int low = 0, high = n - 1, res = -1; 
    while (low <= high) { 
        // Normal Binary Search Logic 
        int mid = (low + high) / 2; 
        if (arr[mid] > x) 
            high = mid - 1; 
        else if (arr[mid] < x) 
            low = mid + 1; 
  
        // If arr[mid] is same as x, we 
        // update res and move to the left 
        // half. 
        else { 
            res = mid; 
            high = mid - 1; 
        } 
    } 
    return res; 
} 
  
/* if x is present in arr[] then returns the index of  
LAST occurrence of x in arr[0..n-1], otherwise  
returns -1 */
int last(int arr[], int x, int n) 
{ 
    int low = 0, high = n - 1, res = -1; 
    while (low <= high) { 
        // Normal Binary Search Logic 
        int mid = (low + high) / 2; 
        if (arr[mid] > x) 
            high = mid - 1; 
        else if (arr[mid] < x) 
            low = mid + 1; 
  
        // If arr[mid] is same as x, we 
        // update res and move to the right 
        // half. 
        else { 
            res = mid; 
            low = mid + 1; 
        } 
    } 
    return res; 
} 
  
// Driver program 
int main() 
{ 
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }; 
    int n = sizeof(arr) / sizeof(int); 
  
    int x = 6; 
    printf("First Occurrence = %d\t", 
           first(arr, x, n)); 
    printf("\nLast Occurrence = %d\n", 
           last(arr, x, n)); 
  
    return 0; 
} 