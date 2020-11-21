package com.learning.binarysearch;

/**
 * @Package: com.learning.binarysearch
 * @Description: 167. Two Sum II - Input array is sorted
 * 				 704. Binary Search
 * @Author: Sammy
 * @Date: 2020/11/9 10:22
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums3 = {1,2,3,4,5,9};
		int[] nums1 = {3,4,6,7,10};
		int[] nums2 = {1, 2, 3, 4, 4, 9, 56, 90};
		System.out.println("---------------");
		// System.out.println(bsearch(nums3, 6, 4));
		// System.out.println(bsearchFirstLarger(nums1, 5, 5));
		for (int i : twoSum(nums2, 8)) {
			System.out.println(i);
		}

	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int i1 = search2(numbers, target - numbers[i], i+1, numbers.length - 1);
			if (i1 == -1) {
				continue;
			} else {
				result = new int[]{i + 1, i1 + 1};
				break;
			}
		}
		return result;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;
		while (left <= right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				result = new int[]{left + 1, right + 1};
			} else if (v < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

    public static int search2(int[] nums, int target,int start,int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid]==target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
    }

	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid]==target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
    }

	/**
	 * 注意简单二分法的三个关键点
	 *  循环条件low<=high
	 *  mid取值,不要溢出：mid = low +(high-low)/2
	 *  low,high变量取值 low=mid+1,high=mid-1, 如果直接写成low=mid会发生死循环
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) { //1. 循环退出条件
			int mid = (high+low)/2;  //2.mid 的取值
			if (a[mid] == value) {
				return mid;
			}else if (a[mid]<value){
				low = mid+1; //3.low 和 high 的更新
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找的递归实现
	 * @param a
	 * @param low
	 * @param high
	 * @param value
	 * @return
	 */
	private int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high) return -1;

		int mid =  low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bsearchInternally(a, mid+1, high, value);
		} else {
			return bsearchInternally(a, low, mid-1, value);
		}
	}

	/**
	 * 二分法变形：查找第一个等于value的元素位置
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearchFirstOccur(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) {
			int mid = (high+low)/2;
			if (a[mid] == value) {
				if ((mid == 0) || a[mid - 1] != value) {
					return mid;
				} else {
					high=mid-1;
				}
			}else if (a[mid]<value){
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

	/**
	 * 二分法变形：查找最后一个等于value的元素位置
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearchLastOccur(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) {
			int mid = (high+low)/2;
			if (a[mid] == value) {
				if ((mid == n-1) || a[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}else if (a[mid]<value){
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

	/**
	 * 二分法变形：查找第一个大于等于给定值的元素
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearchFirstLarger(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if ((mid == 0) || a[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
}
