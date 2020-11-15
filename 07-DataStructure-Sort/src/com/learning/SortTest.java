package com.learning;

/**
 * @Package: com.learning
 * @Description: BubbleSort
 * @Author: Sammy
 * @Date: 2020/11/15 09:34
 */

public class SortTest {

	/**
	 * 在冒泡排序中，只有交换才可以改变两个元素的前后顺序。
	 * 时间复杂度:O(n2)
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			boolean flag = false;
			for (int j =0; j<a.length-1-i;j++) {
				if (a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			System.out.print("第" + i + "趟排序：");
			printArray(a);
			if (!flag) break;
		}
	}

	/**
	 * 插入排序：已排序部分 / 未排序部分
	 * 假定a[0]为已排序部分第一个元素
	 * target = a[i] 找到要插入的位置
	 * 时间复杂度:O(n2)
	 * @param a
	 */
	public static void insertionSort(int[] a){
		for (int i = 1; i < a.length; i++) {
			int target = a[i];
			int j = i - 1;
			while (j >= 0 && target < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j+1] = target;
			System.out.print("第" + i + "趟排序：");
			printArray(a);
		}
	}

	public static void main(String[] args) {
		// int source[] = new int[] { 53, 27, 36, 15, 69, 42 };
		// System.out.print("初始关键字：");
		// printArray(source);
		// System.out.println("");
		// bubbleSort(source);
		// // insertionSort(source);
		// System.out.print("\n\n排序后结果：");
		// printArray(source);
	}

	private static void printArray(int[] source) {
		for (int i = 0; i < source.length; i++) {
			System.out.print("\t" + source[i]);
		}
		System.out.println();
	}
}
