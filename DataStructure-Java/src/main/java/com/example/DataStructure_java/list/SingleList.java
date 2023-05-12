package com.example.DataStructure_java.list;
import java.util.LinkedList;

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
        HeroNode hero4 = new HeroNode(4,"林冲2","豹子头");
        HeroNode hero5 = new HeroNode(5,"林冲2","豹子头");
        HeroNode hero6 = new HeroNode(6,"林冲2","豹子头");
        HeroNode hero7 = new HeroNode(7,"林冲2","豹子头");
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
        singleLinkedList.getLength();
//        System.out.println("结点个数为:" + (singleLinkedList.getLength()));
        System.out.println("test-git");
        System.out.println("test-git");


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
            System.out.println("链表为空!");
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
            System.out.println("链表显示完毕!");
        }

    }

    //添加元素方法二
    /*思路:
        找到小于加入元素的前一个节点(否则无法加入)
    */
    public void addByOrder(HeroNode heroNode)
    {
        HeroNode temp = head;
        boolean flag = false;               //添加的元素是否存在,默认false
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


            if(temp.next == null)
            {
                break;
            }
            if(temp.next.no > heroNode.no)
            {
                break;
            }
            else if(temp.next.no == heroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;

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
        int length = 0;
        if(head.next == null)
        {
            System.out.println("链表为空!");
            return length;

        }
        else
        {
            HeroNode currentNode = head.next;
            while(currentNode != null);
            {
                length++;
                currentNode = currentNode.next;
            }
            System.out.print("链表结点个数为:");
            return length;
        }

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
