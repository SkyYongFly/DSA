### 回溯算法（Backtracking algorithm）

#### 1 应用具体算法或场景

* 深度优先搜索算法、正则表达式匹配、编译原理中的语法分析

* 数独、八皇后、0-1 背包、图的着色、旅行商问题、全排列

#### 2 基本思想

* 类似枚举搜索，枚举所有的解，找到满足期望的解，简单的说其实就是：

  暴力枚举，遍历所有情况，满足情况就停止遍历；

* 把问题分为多个阶段，每个阶段看是否满足条件，不满足回退到上一步重新选择。

#### 3 实际案例

##### 3.1 八皇后

* 问题

  有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。

  <img src="images.assets/1589981474717.png" alt="1589981474717" style="zoom:80%;" />

* 思路

  从第一行选择一个放置元素，接着从第二行选择一个位置放置元素，判断是否满足条件，不满足则换一列位置；依次类推……

  元素是一行一行往后放置，所以不需要关注下面的同列、对角线。只需要看所在行上面的同列、对角线是否有元素。只要已放置元素保证和之前的元素不相交，那么在后面的元素放置时候肯定也不会相交，因为和后面的元素不相交是由后面的元素判断处理保证的。

* 代码

  ```java
  public class Backtracking {
      public static void main(String[] args) {
          b8Queues();
      }
  
  
      // 8皇后算法中保存元素占用位置数组
      // 下标索引代表行，对应值代表列
      private static int[] data = new int[8];
  
      /**
       * 计算8皇后问题
       */
      public static void b8Queues() {
          data = new int[8];
          // 从第一行开始放置元素
          cal8Queues(0);
      }
  
      /**
       * 计算指定行元素应该放在哪一列
       * @param row 行数
       */
      private static void cal8Queues(int row){
          if(row >= 8) {
              // 每一行都放过元素，即已处理完毕
              printData();
              return;
          }
  
          // 元素在每一行都有8列位置可放
          for(int column = 0; column < 8; column++) {
              if(isOk(row, column)) {
                  // 当前行、当前列所在位置能放置元素
                  data[row] = column;
  
                  // 继续放下一行元素
                  cal8Queues(row + 1);
              }
          }
      }
  
      /**
       * 判断元素在指定行、指定列是否能放置，其实就是判断上面的列、左上角、右上角对应位置是否有元素
       * @param row 行
       * @param column 列
       * @return 能 ：true ; 不能 ：false
       */
      private static boolean isOk(int row, int column) {
          // 左边的列
          int leftColumn = column - 1;
          // 右边的列
          int rightColum = column + 1;
  
          // 依次判断前面的行
          for(int r = row - 1; r >= 0; r--) {
              // 判断上面相同列是否有元素
              if(data[r] == column) {
                  return false;
              }
  
              // 判断左上角是否有元素
              if(data[r] == leftColumn) {
                  return false;
              }
  
              // 判断右上角是否有元素
              if(data[r] == rightColum){
                  return false;
              }
  
              // 需要继续往上一行位置判断
              leftColumn--;
              rightColum++;
          }
  
          return true;
      }
  
      /**
       * 打印8皇后元素位置
       */
      private static void printData() {
          for(int row = 0; row < 8; row++) {
              for(int column = 0; column < 8; column++) {
                  if(data[row] == column) {
                      System.out.print("Q ");
                  } else {
                      System.out.print("* ");
                  }
              }
              System.out.println();
          }
          System.out.println();
      }
  }
  ```

  