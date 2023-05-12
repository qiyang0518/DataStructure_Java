package com.example.DataStructure_java.queue_;
import java.util.Scanner;

/**
 * @author 齐阳
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Queue_
{
    public static void main(String[] args)
    {
        //        ArrayQueue arrayQueue = new ArrayQueue(10);
        //        arrayQueue.addQueue(1);
        //        arrayQueue.addQueue(2);
        //        arrayQueue.addQueue(3);
        //        arrayQueue.addQueue(4);
        //        arrayQueue.addQueue(5);
        //        arrayQueue.addQueue(6);
        //        arrayQueue.addQueue(7);
        //        arrayQueue.addQueue(8);
        //        arrayQueue.showQueue();
        //        arrayQueue.outPutQueue();       //1

        ArrayQueue arrayQueue = new ArrayQueue(3);                  //创建容量为3的队列
        char key = ' ';             //用于接受用户选项值
        Scanner scanner = new Scanner(System.in);          //用户键入选项
        boolean loop = true;        //循环判断

        //输出菜单
        while(loop)
        {
            System.out.println("\t\ts(show):显示队列");
            System.out.println("\t\te(exit):推出程序");
            System.out.println("\t\ta(add):添加数据");
            System.out.println("\t\to(outPut):获取元素");
            System.out.println("\t\th(head):查看队列头元素");
            key = scanner.next().charAt(0);                 //用于获取用户操作序号
            switch(key)
            {
                case 's':        //显示队列
                    arrayQueue.showQueue();
                    break;

                case 'a':       //添加数据
                    System.out.println("请输入所要添加的元素:");
                    int Value = scanner.nextInt();
                    arrayQueue.addQueue(Value);
                    break;

                case 'g':       //获取数据
                    try
                    {
                        int res = arrayQueue.outPutQueue();
                        System.out.printf("获取的数据为%d\n",res);
                    } catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':       //获取队列头数据
                    try
                    {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据为%d\n",res);
                    } catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'e':      //退出程序
                    System.out.println("退出程序");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }


    }
}

@SuppressWarnings({"all"})
class ArrayQueue
{
    @SuppressWarnings({"all"})
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;                  //该数组用于存放数据

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize)
    {
        maxSize = arrMaxSize;           //设置队列容量
        arr = new int[maxSize];        //创建maxSize容量的数组
        front = -1;                     //指向队列头部，分析出front时只想队列头的前一个位置
        rear = -1;                      //指向队列尾部，指向队列尾部的数据(即是队列的最后一个元素)
    }

    public boolean isFull()
    {
        return rear == maxSize;        //判断队列是否已满
    }

    public boolean isEmpty()
    {
        return rear == front;        //判断队列是否已满
    }

    //往队列中添加数据
    public void addQueue(int n)       //添加数据n
    {
        if(isFull())                 //首先判断队列是否已满
        {
            System.out.println("队列已满,无法添加数据!");
        }
        rear++;                     //添加成功尾指针后移(rear初始值为-1)
        arr[rear] = n;
    }

    //出列
    public int outPutQueue()
    {
        //判断队列是否为空
        if(isEmpty())
        {
            throw new RuntimeException("队列为空,无数据可取!");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue()
    {
        //遍历
        if(isEmpty())
        {
            System.out.println("队列为空!");
            return;
        }

        System.out.println("====队列输出结果如下====");
//        System.out.print("arr = ");
        for(int i = 0;i < arr.length;i++)
        {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
            //            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列为空!");
        }
        return arr[front + 1];
    }
}
