class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = 0;
        while(lowIndex < highIndex){
            midIndex = lowIndex + (highIndex-lowIndex)/2;
            if(midIndex > 0 && midIndex < nums.length -1 ) {
                if(nums[midIndex] > nums[midIndex - 1] 
                && nums[midIndex] > nums[midIndex + 1]) {
                    return midIndex;
                } else if( nums[midIndex] > nums[midIndex -1]){
                   lowIndex = midIndex + 1;
                } else {
                    highIndex = midIndex -1;
                }
            } else if(midIndex == 0 ){
                if(nums[midIndex] > nums[midIndex + 1]){
                    return midIndex;
                }else{
                    return midIndex + 1;
                }
            }else { 
                if(nums[midIndex] > nums[midIndex - 1]){
                    return midIndex;
                }else{
                    return midIndex - 1;
                }
            }
        }

        return highIndex;
    }
}