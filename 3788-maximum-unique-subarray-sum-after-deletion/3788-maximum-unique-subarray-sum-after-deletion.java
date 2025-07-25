class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        boolean allNeg = true;
        for(int i : nums){
            max = Math.max(max, i);
            if(i > 0){
                allNeg = false;
                break;
            }
        }
        if(allNeg){
            return max;
        }
        else{
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int i : nums){
                if(i>0) set.add(i);
            }
            for(Integer i : set){
                sum += i;
            }
            return sum;
        }
    }
}