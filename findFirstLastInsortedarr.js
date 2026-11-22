/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let len = nums.length;
    if(nums.length === 0) {
        return [-1,-1]; 
    }
        let firstIndex = binarySearchFirst(nums,target,0,len-1 );
        if(firstIndex === -1) return [-1,-1];
        let lastIndex = binarySearchLast(nums,target,firstIndex,len-1);
    return [firstIndex,lastIndex];

};

function binarySearchFirst(nums, target, low, high) {
    while(low<=high) {
        let mid = Math.floor((high+low)/2);
        if(nums[mid] === target) {
            // now we have to check if its the first occurence of the target
            if(mid===0 || nums[mid-1] != target) {
                // its first occurence
                return mid;
            } else {
                high=mid-1;
            }
        } else if (nums[mid] > target) {
            high=mid-1;
        }
        else {
            low=mid+1;
        }
    }
    return -1;
}

function binarySearchLast (nums,target, low, high) {
    while(low<=high) {
        let mid = Math.floor((low+high)/2);
        if(nums[mid] === target ){
            // see if its the last occurence of target
            if(mid === nums.length-1 || target != nums[mid+1]) {
                return mid;
            } else {
                low = mid+1;
            }
        } else if(nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}