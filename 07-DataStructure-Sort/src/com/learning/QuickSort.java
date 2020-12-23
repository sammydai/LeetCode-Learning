package com.learning;

/**
 * @Package: com.learning
 * @Description: Quick Sort
 * @Author: Sammy
 * @Date: 2020/11/15 18:18
 */

public class QuickSort {
	public static void quickSort(int[] data,int left,int right){
		if (left>=right) return;
		if (left < right) {
			int pivot = partition(data, left, right);
			quickSort(data,left,pivot-1);
			quickSort(data,pivot+1,right);
		}
	}

	public static int partition(int[] data, int low, int high) {
		int pivot = data[low];
		while (low < high) {
			while (low < high && data[high] > pivot) {
				high--;
			}
			if (low < high) {
				data[low++] = data[high];
			}
			System.out.print("从右向左扫描<----"+"  这趟排序结果：");
			printArray(data);
			while (low < high && data[low] < pivot) {
				low++;
			}
			if (low < high) {
				data[high--] = data[low];
			}
			System.out.print("从左向右扫描---->"+"  这趟排序结果：");
			printArray(data);
		}
		data[low] = pivot;

		System.out.print("pivot="+pivot+"          这趟排序结果：");
		printArray(data);
		System.out.println("\n");
		return low;
	}

	public static void main(String[] args) {
		int[] source = { 49, 38, 65, 97, 76, 13, 27};
		System.out.print("初始关键字：");
		printArray(source);
		System.out.println("");

		quickSort(source, 0, source.length - 1);

		System.out.print("\n\n排序后结果：");
		printArray(source);
	}

	public static void printArray(int[] source) {
		for (int i = 0; i < source.length; i++) {
			System.out.print("\t" + source[i]);
		}
		System.out.println();
	}
}
