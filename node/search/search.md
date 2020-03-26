### 查找

#### 1 二分查找（Binary Search）—— 无重复元素

##### 1.1 基本思想

针对有序区间，针对目标元素，动态缩小区间匹配，每次折半区间。

##### 1.2 算法实现

- 循环法

  ```java
   /**
       * 循环查找算法
       *
       * @param array 目标数组
       * @param n     数组大小
       * @param value 要查找的值
       * @return 目标元素所在位置
       */
      public static int circleSearch(int[] array, int n, int value){
          // 基本异常判断
  
          int low = 0;
          int high = n - 1;
  
          while(low <= high){
  //            int middle = (low + high) / 2;
  //            int middle = low + (high - low) / 2;
              int middle = low + ((high - low) >> 2);
  
              if(array[middle] == value){
                  return middle;
              } else if(array[middle] > value){
                  high = middle - 1;
              } else {
                  low = middle + 1;
              }
          }
  
          return -1;
      }
  ```

- 递归法

  ```java
  /**
       * 递归查找算法
       *
       * @param array 目标数组
       * @param start 查找区间开始位置
       * @param end 查找区间结束位置
       * @param value 要查找的值
       * @return 目标元素所在位置
       */
      public static int recursionSearch(int[] array, int start, int end,  int value){
          int middle = start + ((end - start) >> 2);
  
          if(array[middle] == value){
              return middle;
          } else if(array[middle] > value){
              return recursionSearch(array, start, middle - 1, value);
          } else {
              return recursionSearch(array, middle + 1, end, value);
          }
      }
  ```

##### 1.3 算法分析

- 时间复杂度 **O(logn)**
  假设总数量n，每次对半后需要查找的区间大小依次为 n/2、n/4...n/(2^k), 即k次折半后的查找区间大小为n/(2^k)，当区间大小只为1的时候肯定能确定最终元素是否能找到，即n/(2^k) = 1时候，k为最多查找次数，计算k=logn,即时间复杂度为O(logn)。

- 局限性：

  A. 依赖数组这样的顺序表结构；

  B. 需要数组有序；

  C. 数据量太小的话可以直接顺序查找，当然如果数据比较比较耗时，还是二分查找降低比较次数；

  数据量太大的话不适合二分查找，因为依赖数组结构，需要连续的大的内存空间；

  D. 适用于静态的不太经常变的数据，较少的排序，多次查找；而经常变的数据需要经常排序消耗时间；

#### 2 二分查找（Binary Search）—— 有重复元素

##### 2.1 查找第一个值等于给定值的元素

```java
/**
     * 查找第一个值等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchFirstEqual(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] == value){
                if(middle == 0 || array[middle - 1] < value){
                    // 如果元素是第一个元素、或者说当前值等于目标值，并且前一个元素值小于当前值，
                    // 因为数组已经有序，那么前面的元素肯定不会有等于当前值的元素，即当前元素就是第一个等于目标值的元素
                    return middle;
                } else {
                    // 当前元素等于目标元素，但是前面紧挨着肯定还有相同元素，所以需要在之前的区间继续查找
                    high = middle - 1;
                }
            } else if(array[middle] > value){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
```

##### 2.2 查找最后一个值等于给定值的元素

```java
/**
     * 查找最后一个值等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchLastEqual(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] == value){
                if(middle == n - 1 || array[middle + 1] > value){
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else if(array[middle] > value){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
```

##### 2.3 查找第一个值大于等于给定值的元素

```java
/**
     * 查找第一个值大于等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchFirstEqualOrLagger(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] >= value){
                if(middle == 0 || array[middle - 1] < value){
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
```

##### 2.4 查找最后一个值小于等于给定值的元素

```java
/**
     * 查找最后一个值小于等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchLastEqualOrLower(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] <= value){
                if(middle == n - 1 || array[middle + 1] > value){
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
```

### 