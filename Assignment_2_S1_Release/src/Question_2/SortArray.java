/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

/**
 *
 * 1. is quick sort the best way to find the median? why?
 *
 * with this we can find the median, but is not necessarily the best way,
 * specially if we only want to find the median, as this algorithm is very
 * efficient to sort large arrays, however if the sole purpose is to find the
 * median this algorithm might be a bit overkill as it will sort the whole array
 * as well, when is not need it.
 *
 * 2. another good way to find the median?
 *
 * using the Median of Median Algorithms, which is specially designed to find
 * the median without sorting the array, with a time complexity of O(n), it will
 * be more efficient to find the median than other methods.
 */
public class SortArray<E extends Comparable> {

    E[] array;

    public SortArray(E[] array) {
        setArray(array);
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public void quickSort() {
        if (array != null) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private void quickSort(E[] list, int h, int t) {
        // check if this elements are in the lsit
        if (h < t) {
            // select the "first" element as pivot
            E pivot = list[h];
            int head = h;
            int tail = t;

            // move elements greather than or equal to the pivot to the right
            // and smaller to the left
            while (head < tail) {
                while (tail > head && list[tail].compareTo(pivot) >= 0) {
                    // reduce tail untill finds an element smaller than the pivot
                    tail--;
                }
                while (head < tail && list[head].compareTo(pivot) < 0) {
                    // increment the head untill finds an element greather than the pivot
                    head++;
                }
                if (head < tail) {
                    // swap elements
                    swap(list, head, tail);
                }
            }
            swap(list, h, tail); // Move pivot to its correct position
            // recursively sort the array before and after the pivot
            quickSort(list, h, tail - 1); // Sort elements before pivot
            quickSort(list, tail + 1, t); // Sort elements after pivot
        }
    }

    private void swap(E[] list, int a, int b) {
        E temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
