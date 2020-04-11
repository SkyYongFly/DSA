### 递归

#### 1 何为递归

方法或函数调用自身的方式称为递归调用，调用称为递，返回称为归；

#### 2 递归示例

例如计算1到100的之间的整数和，可以使用递归算法：

```java
package com.skylaker.recursion;

/*
 * 递归计算：1到100的之间的整数和
 */
public class IntegerSum {
     public static void main(String[] args) {
        System.out.println(sum(100));
     }

     private static int sum(int n) {
         if(1 == n) {
              return 1;
         }
         return sum(n-1) + n;
     }

}
```

#### 3 递归需要满足三个条件

**1. 一个问题可以分解为几个子问题的解**

例如前面的例子计算1到100之间整数和可以分解为1到99的和加上100；其实就是可以大问题分解为小问题；

**2. 这个问题与分解后的子问题，除了数据规模不同，求解思路完全一样**

1到100整数和分解为1到99的和加上100，而这又可以继续往下分，即1到99之间整数和等于1到98整数和加上99，，，而这些计算的思路完全一样的；其实就是存在一定的规律，如果毫无规律可言，那么程序处理只能一个个写死处理了；

**3. 存在递归终止条件**

例如上面的 if(1 == n)  sum = 1; 一层层递归下来，化整为零，大的模块分解为小模块，最终小模块的值必然确定，否则会导致递归无法终止造成为无限递归；

#### 4 如何写出递归代码

写出递归公式，找到终止条件；然后转换成递归代码即可。

递归公式，即处理问题方案之间的**规律性**，例如上述例子，1到n之间的整数和可以表示成如下递归公式：
`sum(n) = sum(n -1) + n`

终止条件，即上述存在递归终止条件项阐述内容；

遇到递归，抽象成递归公式，不需要人脑想一层层调用关系，很容易绕进去；

#### 5 递归缺点

A. 如果递归嵌套太深，容易导致栈溢出异常

因为递归是循环调用方法本身，而Java每次调用方法就会生成对应的栈帧，将当前方法涉及的局部变量等信息压入当前线程栈，而线程栈的大小是不会很大的，层次越深，入栈栈帧越多，线程栈很快就会满，导致 StackOverflowError 报错；

所以要控制递归层次，例如设置计数器计算递归层次，达到一定层次直接返回；

但是因为实际栈的大小以及当前方法栈帧大小不固定，要想设置准确的递归层次不容易，所以一般递归层次确定在一定范围内，例如50、100这样的就可以用递归，实际要根据实际场景来看；

B、递归可能存在重复计算的可能性；

可以将每次f(n)计算的结果用散列表存储，每次获取时候判断是否存在，如果已经存在直接获取，减少重复计算；

C、空间复杂度高

因为每次递归调用都是相当于新调用一次方法，那么局部变量需要重新创建，导致空间复杂度高；

D、时间复杂度高

深层次递归调用必然导致严重耗时；

#### 6 递归优点

表达力强，代码简洁；

#### 7 递归代码改为非递归代码

所有的递归代码都可以改写为迭代循环的方式；例如上述代码可以改写成：

```java
	private static int sum2(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}
```

### 