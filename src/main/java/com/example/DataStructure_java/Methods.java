package com.example.DataStructure_java;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.*;

/**
 * @author 齐阳
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Methods
{
    public static void main(String[] args)
    {
        //表示黑子，2表示白子
        //创建11X11的二维数组
        @SuppressWarnings({"all"}) int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组:");
        for(int[] row : chessArr1)
        {
            for(int data : row)
            {
                System.out.printf("%d\t",data);
            }

            System.out.println();
        }


        //遍历二维数组
        int sum = 0;
        for(int i = 0;i < 11;i++)
        {
            for(int j = 0;j < 11;j++)
            {
                if(chessArr1[i][j] != 0)

                {
                    sum++;
                }
            }
        }


        //创建稀疏数组
        @SuppressWarnings({"all"}) int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 0;                          //用于记录是第几个非0数据
        for(int i = 0;i < 11;i++)
        {
            for(int j = 0;j < 11;j++)
            {
                if(chessArr1[i][j] != 0)
                {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }
            }
        }
        System.out.println();


        //输出稀疏数组
        System.out.println("得到的稀疏数组为:");
        for(int i = 0;i < sparseArr.length;i++)
        {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();


        //数据写入txt文本
        /*
        try
        {
            System.out.println("创建/打开文档");
            File f = new File("C:\\Users\\xml\\Desktop\\spare.txt");
            FileOutputStream f1 = new FileOutputStream(f);
            OutputStreamWriter outf = new OutputStreamWriter(f1,"UTF-8");
            System.out.println("写入中………………");
            for(int i = 0;i < sparseArr.length;i++)
            {
                //不会出错，因为Java自动转为String
                //outf.write(sparseArr[i][0]+","+sparseArr[i][1]+","+sparseArr[i][2]+",");
                //出错，String跟int会乱码
                // outf.write(sparseArr[i][0]);
                // outf.write(",");
                // outf.write(sparseArr[i][1]);
                // outf.write(",");
                // outf.write(sparseArr[i][2]);
                // outf.write(",");


                outf.write(String.valueOf(sparseArr[i][0]));
                outf.write(",");
                outf.write(String.valueOf(sparseArr[i][1]));
                outf.write(",");
                outf.write(String.valueOf(sparseArr[i][2]));
                outf.write(",");

            }
            outf.close();
            f1.close();
            System.out.println("写入成功");
            System.out.println("读取中………………");
            FileInputStream f2 = new FileInputStream(f);
            InputStreamReader inf = new InputStreamReader(f2,"UTF-8");
            StringBuffer sb = new StringBuffer();
            while(inf.ready())
            {
                sb.append((char) inf.read());
            }
            inf.close();
            f2.close();
            System.out.println("读取成功");
            String ss = sb.toString();
            String[] sb1 = sb.toString().split(",");
            System.out.println("读取数据字符串为：");
            System.out.println(ss);

            int num2 = 1;
            int[][] sp = new int[sb1.length / 3][3];
            sp[0][0] = Integer.parseInt(sb1[0]);
            sp[0][1] = Integer.parseInt(sb1[1]);
            sp[0][2] = Integer.parseInt(sb1[2]);
            for(int i = 3;i < sb1.length;i += 3)
            {
                sp[num2][0] = Integer.parseInt(sb1[i]);
                sp[num2][1] = Integer.parseInt(sb1[i + 1]);
                sp[num2][2] = Integer.parseInt(sb1[i + 2]);
                num2++;
            }
            System.out.println("还原稀疏数组：");
            System.out.println("row" + "\t" + "col" + "\t" + "val");
            for(int[] row : sp)
            {
                for(int data : row)
                {
                    System.out.printf("%d\t",data);
                }
                System.out.println();
            }

            System.out.println("还原原始数组：");
            int[][] chessArr3 = new int[sp[0][0]][sp[0][1]];
            for(int i = 1;i < sp.length;i++)
            {
                chessArr3[sp[i][0]][sp[i][1]] = sp[i][2];
            }

            for(int[] row : chessArr3)
            {
                for(int data : row)
                {
                    System.out.printf("%d\t",data);
                }
                System.out.println();
            }

        } catch(IOException e)
        {
            e.printStackTrace();
        }
        //写在外面读取不到sp的
        // System.out.println("还原原始数组：");
        // int[][] chessArr2=new int[sp[0][0]][sp[0][1]];
        // //赋值
        // for(int i=1;i<sp.length;i++){
        // chessArr2[sp[i][0]][sp[i][1]]=sp[i][2];
        // }
        // //打印生成还原的数组
        // System.out.println("还原的数组：");
        // for(int[] row:chessArr2){
        // for(int data:row){
        // System.out.printf("%d\t",data);
        // }
        // System.out.println();
        // }
         */
    }


    //环形队列

    /**
     * 环形队列类
     * 构造器
     * 判断是否已满、判断是否空、查看队列数据、显示队列的有效数据个数、入队列、出队列
     * (rear + 1) % maxSize == front;           //假设maxSize为8,rear = 7,(7 + 1) % 8 = 0证明队列已满
     * (rear + maxSize - front) % maxSize;      //队列中有效个数,rear = 7,maxSize = 8,有效个数为(7 + 8 - 0) % 8 = 7,下标从0开始0-6,共七个元素
     */

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
            return (rear + 1) % maxSize == front;
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
            front = (front + 1) % maxSize;
            return value;
        }
    }


    //往单链表中有序添加元素
    /**
     public void addByOrder(HeroNode heroNode)
     {
     HeroNode temp = head;                //引用头结点作为指针
     boolean flag = false;               //添加的元素是否存在,默认false
     while(true)
     {
     if(temp.next == null)              //判断是否有下一节点
     {
     break;
     }
     if(temp.next.no > heroNode.no)     //temp的下一个节点的值大于新元素的值,表明temp与下一元素之间插入新元素
     {
     break;
     }
     else if(temp.next.no == heroNode.no)       //判断力岸边中是否已经存在该编号的元素
     {
     flag = true;                       //若存在,更改判断量flag为true方便后续添加与否统一判断
     break;
     }
     temp = temp.next;                 //对temp进行递增

     }
     if(flag)
     {
     System.out.println("该编号元素已存在" + heroNode.no);
     }
     else
     {
     heroNode.next = temp.next;
     temp.next = heroNode;
     System.out.println(heroNode.no + "元素添加成功");
     }
     */


    //对Map进行仔细遍历的方法:
    /**
     * 遍历使用I(增强循环)或者迭代器均可
     * 思路:
     * 1、获取Map的entrySet(即Map的底层存储器(里面存储了所有对象,是一个集合))
     *    a、再通过转型(Map.Entry)后,
     *    b、再根据需求进一步获取(key,value)或因需求而异进一步转型
     *    关键代码:
     *    Set entrySet = Map.entrySet();
     *    Employee e = (Employee) (((Map.Entry) entry).getValue());
     *
     * 2、获取Map的keySet(即Map中元素的索引集(经过哈希编码后的))
     *    a、通过Map.get(key)[获取的是与Map的key值的hashCode比较元素的key的hashCode后值相同的返回元素]
     *    b、在对获取的对象进一步按需转型
     *    关键代码:
     *    Set keyset = Map.keySet();
     *    Employee e = (Employee) Map.get(key);
     *
     * 3、通过直接获取Map的values(即Map(K-V)中的V值)
     *    a、而后进行按需转型
     *    Collection values = Map.values();
     *    Employee e = (Employee) value;
     */






    /**
     * git命令行语句:
     *             git status
     *             git add 文件名.后缀
     *             git rm --cached hello.txt
     *             git log
     */
}

