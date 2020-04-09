package demo2;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//这个是任务类
//任务目标是将数组A随机读取到数组B，删除A中的数据，并且使用线程池（大小为3核心线程为1）
public class Mytask implements Runnable{
    //将所求数组放入arraylist中
    Integer[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

    ArrayList<Integer> list2 = new ArrayList<Integer>();

    //获取从0-15之间的随机数作为数组下标
    int arrayid=(int)(5+Math.random()*10);
    //设计一个变量用于表示数组数据的数量
    private static int id = 16;
    private int userid;
    public Mytask (int userid) {
        this.userid = userid;
    }
    @Override
    public void run(){
        String name =Thread.currentThread().getName();
        System.out.println(userid+"正在使用第"+name+"线程参与操作");
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Integer a=list.get(arrayid);
        synchronized (Mytask.class){
            if(a!=null)
            {
                //将获取数组随机位置的数值赋值给list2，并将该位置的list值设置为空
                list2.set(userid,list.get(arrayid));
                list.set(userid,null);
                System.out.println("客户"+userid+"使用第"+name+"线程对数组第"+userid+"个位置操作成功");
                System.out.println("数组第"+userid+"个位置是"+list.get(arrayid));
            }else{
                System.out.println("客户"+userid+"正在使用第"+name+"线程进行操作失败");
            }
        }
    }
}
