package com.learning.binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/11/23 15:46]
 */
public class FindMinBS {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			//   如果中间值小于最大值，则最大值减小
//            疑问：为什么 high = mid;而不是 high = mid-1;
//            解答：{4,5,1,2,3}，如果high=mid-1，则丢失了最小值1
			if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				//    如果中间值大于最大值，则最小值变大
//                疑问：为什么 low = mid+1;而不是 low = mid;
//                解答：{4,5,6,1,2,3}，nums[mid]=6，low=mid+1,刚好nums[low]=1
//                继续疑问：上边的解释太牵强了，难道没有可能low=mid+1,正好错过了最小值
//                继续解答：不会错过!!! 如果nums[mid]是最小值的话，则其一定小于nums[high],走if，就不会走else了
				low = mid + 1;
			}
		}
		return nums[low];
	}
}
