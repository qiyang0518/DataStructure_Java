package com.example.DataStructure_java.doubleLinkedList;
/**
 * @author 齐阳
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class DoubleLinkedList_
{

    public static void main(String[] args)
    {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();


    }

}

@SuppressWarnings({"all"})
        // 创建一个双向链表的类
class DoubleLinkedList                  //创建双向链表
{

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");                    //定义头结点,各属性为空

    // 返回头节点
    public HeroNode2 getHead()
    {
        return head;
    }               //获取头结点

    // 遍历双向链表的方法
    // 显示链表[遍历]

    /**
     * 思路:
     *     1、先判断链表是否为空
     *     2、再对链表进行遍历(判断条件:temp.next是否为空)
     *        a、null,退出循环
     *        b、直至到达null(链表尾部)
     *
     */

    public void list()              //遍历双向链表
    {
        // 判断链表是否为空
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(true)
        {
            // 判断是否到链表最后
            if(temp == null)
            {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表的最后.
    public void add(HeroNode2 heroNode)                 //(尾插法)往链表中添加元素
    {

        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;                          //临时量temp,作为指针
        // 遍历链表，找到最后
        while(true)
        {
            // 找到链表的最后
            if(temp.next == null)
            {//
                break;
            }
            // 如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;                           //后继节点指向新结点
        heroNode.pre = temp;                            //新元素的前驱结点指向temp
    }

    /**
     *
     * @method update
     * 思路:1、传入索引参数
     *     2、判断链表是否为空
     *     3、是否修改结点属性(分支判断,采用boolean flag值进行判断)
     *        a、是否遍历至链未
     *        b、查找到目标结点
     *        c、依据flag值进行分类操作
     *           A、flag为真:进行修改操作
     *           B、flag为假:目标节点未找到
     */

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    public void update(HeroNode2 newHeroNode)               //修改结点属性(根据给定no,进行索引查找,进而修改)
    {
        // 判断是否空
        if(head.next == null)                               //判断链表是否为空
        {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;                         //定义辅助变量temp
        boolean flag = false; // 表示是否找到该节点
        while(true)
        {
            if(temp == null)                                //判断是否遍历至链表尾
            {
                break; // 已经遍历完链表
            }
            if(temp.no == newHeroNode.no)                   //指针temp.no = 元素.no证明已找到
            {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if(flag)
        {
            temp.name = newHeroNode.name;                    //更改结点相关属性
            temp.nickname = newHeroNode.nickname;
        }
        else
        { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n",newHeroNode.no);
        }
    }


    /**
     * @method del(no)
     * 思路: 1、判断链表是否为空
     *      2、对链表进行遍历
     *      3、根据flag值进行分类
     *         a、flag值为真:进行删除操作(temp.pre.next = temp.next、temp.next.pre = next.pre(注意:前提是该节点不是尾结点,尾结点直接略过此运算))
     *         b、flag值为假:删除元素不存在
     */

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no)
    {

        // 判断当前链表是否为空
        if(head.next == null)
        {// 空链表
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next; // 辅助变量(指针)
        boolean flag = false; // 标志是否找到待删除节点的
        while(true)
        {
            if(temp == null)
            { // 已经到链表的最后
                break;
            }
            if(temp.no == no)
            {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移，遍历
        }
        // 判断flag
        if(flag)
        { // 找到
            // 可以删除
            // temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if(temp.next != null)
            {
                temp.next.pre = temp.pre;
            }
        }
        else
        {
            System.out.printf("要删除的 %d 节点不存在\n",no);
        }
    }

}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2
{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no,String name,String nickname)
    {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString()
    {
        return "no=" + no + "\t\tname=" + name + "\t\tnickname=" + nickname;
    }

}
