package com.example.DataStructure_java.sparseArr;

/**
 * @author 齐阳
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SparseArray
{
    public static void main(String[] args)
    {
        /*1表示黑子，2表示白子
            创建11X11的二维数组
         */
        @SuppressWarnings({"all"}) int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][6] = 6;
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
        System.out.println("得到的稀疏数组为:");
        System.out.println("row" + "\t" + "col" + "\t" + "val");
        for(int i = 0;i < sparseArr.length;i++)
        {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();


        //稀疏数组转二维数组
        //根据稀疏数组第一行数据,创建原始数组
        @SuppressWarnings({"all"}) int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //根据稀疏数组其余行(从第二行开始)给恢复后的二维数组进行赋值
        for(int i = 1;i < sparseArr.length;i++)
        {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组:");
        for(int[] row : chessArr2)
        {
            for(int data : row)
            {
                System.out.printf("%d\t",data);
            }

            System.out.println();
        }


        //将数组存入磁盘,使用时从磁盘中读取(以下代码可以实现)
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
}
