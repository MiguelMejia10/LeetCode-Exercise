class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];

            if (numIndices.containsKey(complement)) {
                return new int[] {numIndices.get(complement), i};

            }

            numIndices.put(nums[i], i);

        }

        throw new IllegalArgumentException("No solutions found");

    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Resultado 1: [" + result1[0] + ", "+ result1[1]+"]");

        int[] nums2 = {3,2,4};
        int target2 =6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Resultado 2: [" + result2[0]+ "," + result2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Resultado 3: [" + result3[0] + ", " + result3[1] + "]");

    }
}