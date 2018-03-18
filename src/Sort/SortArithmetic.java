package Sort;

/**
 * 内部排序：
 * H插入排序：1、直接插入 2、希尔排序
 */
public class SortArithmetic {
    /**
     * 插入排序
     * 复杂度n^2
     * 稳定
     *
     * @param array0
     */
    private void insertSort(int[] array0) {
        for (int i = 1; i < array0.length; i++) {
            int j = 0;
            int t = array0[i];
            for (j = i; j > 0 && t < array0[j - 1]; j--) {
                array0[j] = array0[j - 1];
            }
            array0[j] = t;
        }
    }

    /**
     * 希尔排序
     * 不稳定
     *
     * @param a
     */
    private void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk > 1) {
            shellInsertSort(a, dk);
        }
    }

    private void shellInsertSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {//dk长度需要插入算法
                int j;
                int t = a[i];
                for (j = i - dk; j > 0 && t < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j] = t;
            }
        }
    }

    /**
     * 简单选择
     * 不稳定
     *
     * @param a
     */
    private void simpleSelectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int t = i;
            for (int j = i + 1; j < a.length; j++) {//找到该趟最小的
                if (a[j] < a[t]) {
                    t = j;
                }
            }
            int tt = a[t];//交换
            a[t] = a[i];
            a[i] = a[tt];
        }
    }

    /**
     * 快速排序
     * 不稳定
     *
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers) {
        if (numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }

    }

    /**
     * @param array
     * @param parent
     * @param length
     */
    public void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }

    /**
     * 堆排序
     * 不稳定
     *
     * @param list
     */
    public void heapSort(int[] list) {
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.length - 1);
        }
        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i);
            System.out.format("第 %d 趟: \t", list.length - i);
        }
    }

    /**
     * 快速排序
     * 不稳定
     *
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }
}
