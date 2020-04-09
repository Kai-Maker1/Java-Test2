package demo2;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//这个是主函数调用类

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList1=new ArrayList();
        //1.创建线程池
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,3,100, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        //2.循环创建任务对象序列
        for (int i = 0; i <=20 ; i++) {
            Mytask mytask=new Mytask(i);
            pool.submit(mytask);
        }
        //3.关闭线程池
        pool.shutdown();

//        //遍历数组list2。
//        for (int i = 0; i <=15; i++) {
//            System.out.println(list2.get(i) );
//        }
    }
}
