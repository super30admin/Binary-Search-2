// min is always on the unsorted half
// unsorted half is half of array that is  unsorted from mid's perspective
// min is an element that is smallest among its immediate neighbors ( left and right )
// so to find mid, find sorted side from mid's perspective - take the search on unsorted half
// at some point, the search on unsorted half will be the smallest sorted half, when this happens return left

func findMin(nums []int) int {
    if nums == nil || len(nums) == 0 {
        return -1
    }
    
    left := 0
    right := len(nums)-1
    
    for left <= right {
        mid := left + (right-left)/2
        
        // is this range already sorted?
        if nums[left] < nums[right] {
            // if yes, left has to be the smallest, so return left
            return nums[left]
        }
        
        if (mid==0 || nums[mid] < nums[mid-1]) && (mid==len(nums)-1 || nums[mid] < nums[mid+1]) {
            return nums[mid]
        } else if nums[left] <= nums[mid] {
            // left sorted - search on the unsorted half ( right )
            left = mid+1
        } else {
            // right sorted - search on the unsorted half ( left )
            right = mid-1
        }
    }
    return -1
}
// brute force: linear search and keep track of min
// time = o(n)
// space = o(1)
// func findMin(nums []int) int {
//     min := math.MaxInt64
//     for i := 0; i < len(nums); i++ {
//         if nums[i] < min {
//             min = nums[i]
//         }
//     }
//     return min
// }
