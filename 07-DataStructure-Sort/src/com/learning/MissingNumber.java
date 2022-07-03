package com.learning;

/**
 * @Package: com.learning
 * @Description: 268. Missing Number
 * @Author: Sammy
 * @Date: 2020/11/22 16:27
 */

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int size = nums.length;
        int i =0;
        while(i<size){
            //交换nums[i]应该在的位置：nums[i] 和 nums[nums[i]]-->cur（现在错误的位置） 和 nums[cur](应该在的位置)
            int cur = nums[i];
            if(nums[i]!=size && nums[i]!=i){
                int temp = nums[cur];//正在遍历的这个值应该在地方，nums[cur]值现在不对，所有要存临时变量
                nums[cur] = nums[i];// 把正确的值，nums[i]赋值给正确的位置num[cur]
                nums[i] = temp;//这个错误的值，交换给现在的地方
            }else{
                i++;
            }
        }
        for(int j=0;j<size;j++){
            if(nums[j]!=j) return j;
        }
        return size;
    }

     public int missingNumberNew(int[] nums) {

		 int i = 0;
		 while (i < nums.length) {
			 int cur = nums[i];
			 if (nums[i] != i && nums[i] != nums.length) {
				 int temp = nums[cur];
				 nums[cur] = nums[i];
				 nums[i] = temp;
			 } else {
				 i++;
			 } 
		 }
		 for (int j = 0; j < nums.length; j++) {
			 if (j!=nums[j]) return j;
		 }
		 return nums.length;
    }
}
