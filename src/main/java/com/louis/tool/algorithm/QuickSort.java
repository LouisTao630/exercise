package com.louis.tool.algorithm;

public class QuickSort {

	public static int[] sortArray(int[] array, int begin, int end) {

		int key = array[begin];
		int forwardIndex = begin;
		int reverseIndex = end;
		boolean isForward = false;
		while (forwardIndex != reverseIndex) {

			if (isForward) {
				if (array[forwardIndex] <= key) {
					forwardIndex++;
					continue;
				}
				array[reverseIndex] = array[forwardIndex];
				array[forwardIndex] = key;
				isForward = false;
			} else {
				if (array[reverseIndex] > key) {
					reverseIndex--;
					continue;
				}
				array[forwardIndex] = array[reverseIndex];
				array[reverseIndex] = key;
				isForward = true;

			}
		}
		if (forwardIndex != begin) {
			sortArray(array, begin, forwardIndex);
		}
		if (end > (reverseIndex + 1)) {
			sortArray(array, reverseIndex + 1, end);
		}
		return array;
	}

}
