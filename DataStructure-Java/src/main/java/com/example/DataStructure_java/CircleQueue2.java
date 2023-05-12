package com.example.DataStructure_java;
/**
 * @author 齐阳
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class CircleQueue2
{
    public static void main(String[] args)
    {

    }
}

/**
 * 环形队列类
 * 构造器
 * 判断是否已满、判断是否空、查看队列数据、显示队列的有效数据个数、入队列、出队列
 */
@SuppressWarnings({"all"})
class CircleQueue
{
    //    数组的最大容量
    private final int maxSize;
    //    front指向队列的第一个元素，初始值为0
    private int front;
    //    rear指向队列的最后一个元素的后一个位置，空出一个空间作为约定，初始值为0
    private int rear;
    //    存放数据，模拟队列
    private final int[] arr;

    //    创建队列构造器
    public CircleQueue(int maxSize)
    {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    //    判断队列是否已满
    public boolean isFull()
    {
        return (rear + 1) % maxSize == front;           //假设maxSize为8,rear = 7,(7 + 1) % 8 = 0证明队列已满
    }

    //    判断队列是否为空
    public boolean isEmpty()
    {
        return rear == front;
    }

    //    查看队列数据,显示队列所有数据
    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("队列为空，没有数据！");
            return;
        }
        //        从front开始遍历，注意遍历的元素个数
        for(int i = front;i < front + size();i++)
        {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }

    }

    //    求出当前队列有效数据的个数
    public int size()
    {
        return (rear + maxSize - front) % maxSize;
    }

    //    显示队列的头数据，注意不是取出数据
    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列是空的，没有数据！");
        }
        return arr[front];
    }

    //    添加数据到队列
    public void addQueue(int n)
    {
        if(isFull())
        {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        System.out.println(n + "成功添加到队列");
        //        将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //    从队列取出数据,，出队列
    public int getQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列为空，无法取出数据");
        }
        //        这里需要分析出front是指向队列的第一个元素
        //        1. 先把front对应的值保留到一个临时变量
        //        2. 将front后移，考虑取模
        //        3. 将临时保存的变量取回
        int value = arr[front];
        front = (front + 1) % maxSize;      //取模防止越界
        return value;
    }
}

