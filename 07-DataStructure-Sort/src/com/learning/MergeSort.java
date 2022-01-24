package com.learning;

/**
 * @Package: com.learning
 * @Description: Merge Sort
 * @Author: Sammy
 * @Date: 2020/11/15 18:19
 */

public class MergeSort {
	/**
	 * 归并排序:分而治之
	 * 递归代码来实现归并排序
	 * https://ouyangpeng.blog.csdn.net/article/details/46625155
	 * @param data
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] data, int left, int right){
		if (left>=right) return;
		int mid = (right + left) / 2;
		mergeSort(data,left,mid);
		mergeSort(data,mid+1,right);
		merge(left,mid,mid+1,right,data);
		System.out.print("排序中:\t");
		print(data);
	}


	public static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd, int[] data) {
		int i = leftStart;
		int j = rightStart;
		int[] temp = new int[rightEnd - leftStart + 1];
		int k = 0;
		while (i <= leftEnd && j <= rightEnd) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];
			}
		}
		// 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while (i <= leftEnd) {
			temp[k++] = data[i++];
		}
		while (j <= rightEnd) {
			temp[k++] = data[j++];
		}
		k = leftStart;
		// 将临时数组中的内容拷贝回原数组中
		// （原left-right范围的内容被复制回原数组）
		for (int element : temp) {
			data[k++] = element;
		}
	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] data = new int[] { 2, 4, 7, 5, 8, 1, 3, 6 };
		System.out.print("初始化：\t");
		print(data);
		System.out.println("");
		mergeSort(data, 0, data.length - 1);
		System.out.print("\n排序后:  \t");
		print(data);
	}
}
