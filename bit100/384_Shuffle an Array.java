// Shuffle a set of numbers without duplicates.

// Example:

// // Init an array with set 1, 2, and 3.
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
// solution.shuffle();

// // Resets the array back to its original configuration [1,2,3].
// solution.reset();

// // Returns the random shuffling of array [1,2,3].
// solution.shuffle();


class Solution {
    private int[] nums;
    private Random rmd;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rmd = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] clone = this.nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int random = this.rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        
        return clone;
    }
    
    public void swap(int[] clone, int i, int j) {
        int tmp = clone[i];
        clone[i] = clone[j];
        clone[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */