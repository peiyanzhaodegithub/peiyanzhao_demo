package com.example.demo.algorithm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/6 14:34
 * @Description: 基本排序算法
 */
public class BasicAlgorithm {


    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 4};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**--------------------------------------冒泡排序-----------------------------------------*/

    /**
     * 通过与相邻元素的比较和交换来把小的数交换到最前面。这个过程类似于水泡向上升一样，因此而得名。
     * 举个栗子，对5,3,8,6,4这个无序序列进行冒泡排序。
     * 首先从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。
     * 同理4和8交换，变成5,3,4,8,6,3和4无需交换。
     * 5和3交换，变成3,5,4,8,6,3.这样一次冒泡就完了，把最小的数3排到最前面了。对剩下的序列依次冒泡就会得到一个有序序列。
     * 冒泡排序的时间复杂度为O(n^2)。
     */
    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    /**--------------------------------------选择排序---------------------------------------------*/

    /**
     * 选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面。
     * 但是过程不同，冒泡排序是通过相邻的比较和交换。而选择排序是通过对整体的选择。
     * 举个栗子，对5,3,8,6,4这个无序序列进行简单选择排序，首先要选择5以外的最小数来和5交换，也就是选择3和5交换，一次排序后就变成了3,5,8,6,4.
     * 对剩下的序列一次进行选择和交换，最终就会得到一个有序序列。
     * 其实选择排序可以看成冒泡排序的优化，因为其目的相同，只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。
     * 选择排序的时间复杂度为O(n^2)
     */

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) { //只需要比较n-1次
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) { //如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**-----------------------------------------插入排序---------------------------------------------*/

    /**
     * 插入排序不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的。
     * 相信大家都有过打扑克牌的经历，特别是牌数较大的。在分牌时可能要整理自己的牌，牌多的时候怎么整理呢？就是拿到一张牌，找到一个合适的位置插入。这个原理其实和插入排序是一样的。
     * 举个栗子，对5,3,8,6,4这个无序序列进行简单插入排序，首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理。然后3要插到5前面，把5后移一位，变成3,5,8,6,4.想一下整理牌的时候应该也是这样吧。然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。
     * 注意在插入一个数的时候要保证这个数前面的数已经有序。
     * 简单插入排序的时间复杂度也是O(n^2)。
     */

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length; i++) { //假设第一个数位置时正确的；要往后移，必须要假设第一个。

            int j = i;
            int target = arr[i]; //待插入的

            //后移
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            //插入
            arr[j] = target;
        }

    }


    /**----------------------------------------------快速排序---------------------------------------------------*/

    /**
     * 举个栗子：对5,3,8,6,4这个无序序列进行快速排序，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。
     * 5,3,8,6,4 用5作为比较的基准，最终会把5小的移动到5的左边，比5大的移动到5的右边。
     * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描（思考一下为什么？）4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
     * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
     * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
     * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)。
     */

    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            arr[left] = arr[right]; //把小的移动到左边
            while (left < right && arr[left] <= pivotKey)
                left++;
            arr[right] = arr[left]; //把大的移动到右边
        }
        arr[left] = pivotKey; //最后把pivot赋值到中间
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    /**--------------------------------------------堆排序----------------------------------------------*/

    /**
     * 堆筛选，除了start之外，start~end均满足大顶堆的定义。
     * 调整之后start~end称为一个大顶堆。
     *
     * @param arr   待调整数组
     * @param start 起始指针
     * @param end   结束指针
     */

    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        for (int i = 2 * start + 1; i <= end; i *= 2) {
            //左右孩子的节点分别为2*i+1,2*i+2

            //选择出左右孩子较小的下标
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (temp >= arr[i]) {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛选
        }

        arr[start] = temp; //插入正确的位置
    }


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        //建立大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i - 1);
        }

    }

    /**----------------------------------------------希尔排序----------------------------------------------*/

    /**
     * 希尔排序的一趟插入
     *
     * @param arr 待排数组
     * @param d   增量
     */

    public static void shellInsert(int[] arr, int d) {
        for (int i = d; i < arr.length; i++) {
            int j = i - d;
            int temp = arr[i];    //记录要插入的数据
            while (j >= 0 && arr[j] > temp) {  //从后向前，找到比其小的数的位置
                arr[j + d] = arr[j];    //向后挪动
                j -= d;
            }

            if (j != i - d)    //存在比其小的数
                arr[j + d] = temp;

        }
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }

    /**
     * ----------------------------------------------归并排序------------------------------------------------
     */

    public static void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归分治
     *
     * @param arr   待排数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void mSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;

        mSort(arr, left, mid); //递归排序左边
        mSort(arr, mid + 1, right); //递归排序右边
        merge(arr, left, mid, right); //合并
    }

    /**
     * 合并两个有序数组
     *
     * @param arr   待合并数组
     * @param left  左指针
     * @param mid   中间指针
     * @param right 右指针
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        //[left, mid] [mid+1, right]
        int[] temp = new int[right - left + 1]; //中间数组

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

    }

    /**-------------------------------------------------计数排序-------------------------------------------------*/

    /**
     * 用待排序的数作为计数数组的下标，统计每个数字的个数。然后依次输出即可得到有序序列
     */

    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int max = max(arr);

        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }

    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }

        return max;
    }

    /**
     * -----------------------------------------------桶排序---------------------------------------------
     */

    public static void bucketSort(int[] arr) {
        if (arr == null && arr.length == 0)
            return;

        int bucketNums = 10; //这里默认为10，规定待排数[0,100)
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(); //桶的索引

        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<Integer>()); //用链表比较合适
        }

        //划分桶
        for (int i = 0; i < arr.length; i++) {
            buckets.get(f(arr[i])).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < buckets.size(); i++) {
            if (!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i)); //对每个桶进行快排
            }
        }

        //还原排好序的数组
        int k = 0;
        for (List<Integer> bucket : buckets) {
            for (int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }

    /**
     * 映射函数
     *
     * @param x
     * @return
     */
    public static int f(int x) {
        return x / 10;
    }

    /**
     * ----------------------------------------------基数排序----------------------------------------------
     */

    public static void radixSort(int[] arr) {
        if (arr == null && arr.length == 0)
            return;

        int maxBit = getMaxBit(arr);


        for (int i = 1; i <= maxBit; i++) {

            List<List<Integer>> buf = distribute(arr, i); //分配
            collecte(arr, buf); //收集
        }

    }

    /**
     * 分配
     *
     * @param arr  待分配数组
     * @param iBit 要分配第几位
     * @return
     */
    public static List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for (int j = 0; j < 10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }

    /**
     * 收集
     *
     * @param arr 把分配的数据收集到arr中
     * @param buf
     */
    public static void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for (List<Integer> bucket : buf) {
            for (int ele : bucket) {
                arr[k++] = ele;
            }
        }


    }

    /**
     * 获取最大位数
     *
     * @param arr
     * @return
     */
    public static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            int len = (ele + "").length();
            if (len > max)
                max = len;
        }
        return max;
    }

    /**
     * 获取x的第n位，如果没有则为0.
     *
     * @param x
     * @param n
     * @return
     */
    public static int getNBit(int x, int n) {

        String sx = x + "";
        if (sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length() - n) - '0';
    }


}
