package com.example.DataStructure_java.list;
import java.util.Stack;

/**
 * @author 齐阳
 * @version 1.0
 * 关注:有序添加元素(addByOrder())
 * 亮点:
 * 直接在内存中进行排序,方便后续遍历
 * 对增加新元素成功(true)与否(false),进行了分离,提高了代码的可读性
 * 对于在哪个位置添加元素,进行了简化,方法非常巧妙(heroNode.next = temp.next;  temp.next = heroNode;)
 */
@SuppressWarnings({"all"})
public class SingleList
{
    public static void main(String[] args)
    {
        HeroNode hero1 = new HeroNode(1,"宋江2","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义2","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用2","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲1","豹子头");
        HeroNode hero5 = new HeroNode(5,"林冲2","豹子头");
        HeroNode hero6 = new HeroNode(6,"林冲3","豹子头");
        HeroNode hero7 = new HeroNode(7,"林冲4","豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.addByOrder(hero6);
        singleLinkedList.addByOrder(hero7);
        singleLinkedList.showLinkedList();
        HeroNode hero8 = new HeroNode(4,"林冲","豹子头~~");
        singleLinkedList.update(hero5);
        singleLinkedList.showLinkedList();
        //        System.out.println("结点个数为:" + (singleLinkedList.getLength()));
        singleLinkedList.remove(1);
        System.out.println("删除后的结果:");
        singleLinkedList.showLinkedList();
        //        System.out.println("结点个数为:" + (singleLinkedList.getLength()));
        singleLinkedList.remove(2);
        System.out.println("删除后的结果:");
        singleLinkedList.showLinkedList();
        //        singleLinkedList.getLength();
        System.out.println("结点个数为:" + singleLinkedList.getLength());
        System.out.println(singleLinkedList.getIndexHero(3));
        System.out.println(singleLinkedList.getLastIndexHero(3));

        System.out.println("=========" + "顺序链表" + "===========");
        singleLinkedList.showLinkedList();
//        singleLinkedList.reversePrint();

        System.out.println("反转后的链表:");
//        singleLinkedList.reverseMethod1();
        System.out.println("2023/5/15");
        HeroNode hero9 = new HeroNode(7,"吴用2","智多星");
        HeroNode hero10 = new HeroNode(8,"林冲1","豹子头");
        HeroNode hero11 = new HeroNode(9,"林冲2","豹子头");
        HeroNode hero12 = new HeroNode(10,"林冲3","豹子头");
        HeroNode hero13 = new HeroNode(11,"林冲4","豹子头");
        SingleLinkedList list2 = new SingleLinkedList();
        list2.addByOrder(hero9 );
        list2.addByOrder(hero10);
        list2.addByOrder(hero11);
        list2.addByOrder(hero12);
        list2.addByOrder(hero13);

        //合并没实现
//        System.out.println("合并两个链表,并顺序打印如下:");
//        singleLinkedList.addListByOrder(singleLinkedList,list2);
//        singleLinkedList.showLinkedList();
    }

    public static int getLength(HeroNode head)
    {
        int length = 0;
        HeroNode temp = head.next;
        if(head.next == null)
        {
            return 0;
        }
        else
        {
            while(temp != null)
            {
                length++;
                temp = temp.next;
            }
        }
        return length;
    }
}

@SuppressWarnings({"all"})
class SingleLinkedList
{
    private HeroNode head = new HeroNode(0,"","");              //定义一个头结点,内容为空


    public void add(HeroNode heroNode)                  //添加元素(传入一个节点)
    {
        HeroNode temp = head;                              //后面添加元素需要改变头节点的next,为了不影响头节点,创建一个暂存节点,替代头节点
        while(true)
        {
            if(temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //显示链表
    public void showLinkedList()
    {
        if(head.next == null)
        {
//            System.out.println("链表为空!");
            return;
        }
        else
        {
            HeroNode temp = head.next;
            while(true)
            {
                if(temp == null)
                {break;}
                else
                {
                    System.out.println(temp);
                    temp = temp.next;
                }

            }
//            System.out.println("链表显示完毕!");
        }

    }

    //添加元素方法二
    /*思路:
        找到小于加入元素的前一个节点(否则无法加入)
    */
    public void addByOrder(HeroNode heroNode)
    {
        HeroNode temp = head;
        boolean flag = false;               //添加的元素是否存在,默认false,默认有位置插入元素
        while(true)
        {
            //            if(temp.next == null)
            //            {
            //                temp.next = heroNode;
            //            }
            //            if((heroNode.no > temp.next.no && temp.next.next.no >heroNode.no))           //如果第一个元素的no值小于加入元素值
            //            {
            //                temp.next.next = heroNode.next;
            //                heroNode.next = temp.next.next.next;
            //                break;
            //            }
            //            if(temp.next.no == heroNode.no)
            //            {
            //                System.out.println("元素已存在,添加失败!");
            //                break;
            //            }
            //            temp = temp.next;


            //
            //            if(temp.next == null)
            //            {
            //                temp.next = heroNode;
            //            }
            //            if(temp.next.no > heroNode.no)
            //            {
            //                heroNode.next = temp.next;
            //                temp.next = heroNode;
            //            }
            //            if(temp.next.no == heroNode.no)
            //            {
            //                flag = true;
            //                System.out.println("元素已存在!");
            //                break;
            //            }
            //            temp = temp.next;       //遍历当前列表


            if(temp.next == null)                           //判断下一个元素是否为空
            {
                break;                                      //空则推出循环
            }
            if(temp.next.no > heroNode.no)                  //判断县各元素的no是否大于新增元素的no
            {
                break;                                      //如果大于证明temp与temp.next就是插入的位置
            }
            else if(temp.next.no == heroNode.no)            //判断temp的下一个元素的no是否与新增元素的no
            {
                flag = true;                                //修改flag值,不插入元素
                break;
            }
            temp = temp.next;                               //temp递增(指针后移)

        }
        if(flag)                                            //flag = true 元素已存在
        {
            System.out.println("该编号元素已存在" + heroNode.no);
        }
        else
        {
            heroNode.next = temp.next;
            temp.next = heroNode;
            System.out.println(heroNode.no + "元素添加成功");
        }
    }

    public void update(HeroNode heroNode)           //修改元素
    {
        //思路:
        //先判断链表是否为空
        //对链表进行遍历(判断条件元素的no值),查找到相同no值则进行修改,反之,则说明元素不存在
        if(head.next == null)           //链表为空
        {
            System.out.println("链表为空!");
        }
        HeroNode temp = head.next;          //head替代量
        boolean flag = false;
        while(true)
        {
            if(temp == null)
            {break;}
            if(temp.no == heroNode.no)
            {
                //                System.out.println("元素存在" + heroNode.toString());
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
        {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }
        else
        {
            System.out.println("链表遍历结束" + heroNode.no + "元素为不存在!");
        }
    }

    public void remove(int no)
    {
        HeroNode temp = head;                               //head节点的替代量,作为指针,遍历链表
        boolean flag = false;                               //判断是否找到元素,默认为flase
        while(true)
        {
            if(temp.next == null)                               //已经遍历至链尾
            {
                break;
            }
            if(temp.next.no > no)                               //已经找到删除结点的前一个结点
            {
                flag = true;
                break;
            }
            temp = temp.next;                               //指针递增
        }
        if(flag)                                //根据flag判断是否找到,再进行操作
        {
            temp.next = temp.next.next;                             //被移除元素的前一节点的指针指向后两个元素
            System.out.println(no + "元素被移除!");
        }
        else
        {
            System.out.println(no + "元素不存在!");
        }
    }

    public int getLength()
    {
        /**
         * 只能获取一次链表长度
         HeroNode temp = head;
         int length = 0;
         if(temp.next == null)
         {
         System.out.println("链表长度为:" + length);
         return length;
         }
         else
         {
         while(temp.next != null)
         {
         length++;
         temp.next = temp.next.next;
         }
         return length;
         }
         */

        //改进版
        int length = 0;                                      //定义链表长度默认为0
        if(head.next == null)                                //判断链表是否为空
        {
            System.out.println("链表为空!");                  //链表为空,返回length = 0
            return length;
        }
        else
        {
            HeroNode currentNode = head.next;                    //定义指针currentNode,对列表进行遍历
            while(currentNode != null)
            {
                //                System.out.println("1");
                length++;                                   //length自增
                currentNode = currentNode.next;             //指针递增
            }
            ;
            System.out.print("链表结点个数为:");
            return length;
        }
    }

    public HeroNode getIndexHero(int index)
    {
        HeroNode temp = head.next;
        HeroNode goalHero = null;
        int indexHero = 0;
        if(temp == null)
        {
            System.out.println("链表为空,元素不存在!");
            return null;
        }
        else
        {
            while(temp != null)
            {
                indexHero++;
                if(temp.next == null)
                {
                    goalHero = temp;
                }
                temp = temp.next;
                //                System.out.println("1");

            }
            System.out.println("indexHero:" + indexHero);
            if(index + 1 > indexHero)               //index = 3 indexHero = 5
            {
                System.out.println(index + "这个节点不存在");
                return null;
            }
            //            System.out.println("2");
            return goalHero;
        }
    }

    /**
     * 获取链表倒数第K个元素
     * 采用双指针方法进行遍历temp1,temp2(默认从第一个元素开始遍历)
     * 思路:temp2比temp1先遍历K-1个元素,而后temp1,temp2同时遍历
     * 直至temp2为null时,证明temp1就是链表倒数第K个元素
     */

    public HeroNode getLastIndexHero(int index)
    {
        if(head.next == null)
        {
            System.out.println("链表为空,元素不存在");
        }
        HeroNode temp1 = head.next;
        HeroNode temp2 = head.next;
        for(int i = 0;(i < index - 2 && temp2 != null);i++)
        {
            temp2 = temp2.next;
        }
        System.out.println(temp2);
        while(temp2 != null)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.println("倒数第三个元素是:");
        return temp1;
    }

    public void reverseMethod1()
    {
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode next = null;
        HeroNode temp = head.next;
        {
            if(temp == null || temp.next == null)
            {
                System.out.println("链表为空!");
            }
            else
            {
                while(temp != null)
                {
                    //                    System.out.println("2");
                    //                    reverseHead = temp;
                    //                    next = temp.next;
                    //                    temp = temp.next;
                    //                    reverseHead.next = reverseHead;
                    next = temp.next;
                    temp.next = reverseHead.next;
                    reverseHead.next = temp;
                    temp = next;
                }
            }
        }
        while(reverseHead.next != null)
        {
            System.out.println(reverseHead.next);
            reverseHead = reverseHead.next;
            //            System.out.println("1");
        }
    }

    public void reverseMethod2()
    {

    }

    public void reversePrint()
    {
        HeroNode temp = head.next;
        Stack stack = new Stack();
        if(temp == null)
        {
            System.out.println("链表为空!");
        }
        else
        {
            while(temp != null)
            {
                stack.push(temp);
                temp = temp.next;
                //                System.out.println("1");
            }
            System.out.println("逆序打印链表如下:");
            //            System.out.println(stack.pop());
            while(stack.size() > 0)
            {
                System.out.println(stack.pop());
            }
        }
    }

    public void addListByOrder(SingleLinkedList list1,SingleLinkedList list2)
    {
        //没实现
        //默认两个链表都是有序的,都是根据addByOrder()方法添加元素
        //把链表二作为新增链表,加至链表一
        HeroNode heroNode = new HeroNode(0,"","");
        HeroNode temp1 = list1.head.next;
        HeroNode temp2 = list2.head.next;
        HeroNode tempNode = heroNode;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.no < temp2.no)
            {
                tempNode.next = temp1.next;
                temp1 = temp1.next;
            }
            else
            {
                tempNode.next = temp2;
                temp2 = temp2.next;
            }
            tempNode = tempNode.next;
        }
        if(temp1 == null)
        {
            tempNode.next = temp2;
        }
        else
        {
            tempNode = temp1;
        }
        temp1 = tempNode.next;
        /**
         * HeroNode temp1 = list1.head.next;
         *         SingleLinkedList templist = new SingleLinkedList();
         *         HeroNode temp2 = list2.head.next;
         *         boolean flag = false;
         *         while(true)
         *         {
         *             HeroNode newNode = temp2;
         *             if(temp1 != null)
         *             {
         *                 if(temp2.next != null)
         *                 {
         *                     if(temp1.next.no > newNode.no)
         *                     {
         *                         break;
         *                     }
         *                     else if(temp1.next.no == newNode.no)
         *                     {
         *                         flag = true;
         *                         break;
         *                     }
         *                 }
         *                 else
         *                 {
         *                     System.out.println("list2链表为:" + null);
         *                     break;
         *                 }
         *                 temp1 = temp1.next;
         *
         *             }
         *             else
         *             {
         *                 System.out.println("list1链表为:" + null);
         *                 break;
         *             }
         *
         *
         *
         *             //            if(temp1.next == null)
         *             //            {
         *             //                System.out.println("list1链表为:" + null);
         *             //                break;
         *             //            }
         *             //            else if(temp2.next == null)
         *             //            {
         *             //                System.out.println("list2链表为:" + null);
         *             //                break;
         *             //            }
         *             //            else if(temp1.next.no > temp2.no)                   //(temp2.no > temp1.no) && (temp1.next.no > temp2.no)
         *             //            {
         *             //                break;
         *             //            }
         *             //            else if(temp1.next.no == temp2.no)
         *             //            {
         *             //                flag = true;
         *             //                break;
         *             //            }
         *             //            //                temp2.next = temp1.next;
         *             //            //                temp1.next = temp2;
         *             //            temp1 = temp1.next;
         *             //            temp2 = temp2.next;
         *             //        }
         *
         *             while(newNode.next != null)
         *             {
         *
         *                 if(flag)
         *                 {
         *                     System.out.println("该编号元素已存在" + newNode.no);
         *                 }
         *                 else
         *                 {
         *                     try
         *                     {
         *                         newNode.next = temp1.next;
         *                         temp1.next = newNode;
         *                         System.out.println(newNode.no + "元素添加成功");
         *                     } catch(Exception e)
         *                     {
         *                         System.out.println(e.getMessage());
         *                     }
         *                 }
         *                 temp2 = temp2.next;
         *             }
         *         }
         *
         */
    }
}

@SuppressWarnings({"all"})
class HeroNode
{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no,String name,String nickName)
    {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString()
    {
        return "no=" + no + "\t\tname=" + name + "\t\tnickName=" + nickName;
    }

}

