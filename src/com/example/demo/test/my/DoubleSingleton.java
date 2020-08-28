package com.example.demo.test.my;

/*第二次判空是防止多线程情况下发生以下情况:
        a.假设：线程A已经经过第一次判断，判断singleton=null，准备进入同步代码块.
        b.此时线程B获得时间片，犹豫线程A并没有创建实例，所以，判断singleton仍然=null，所以线程B创建了实例singleton。
       c.此时，线程A再次获得时间片，犹豫刚刚经过第一次判断singleton=null(不会重复判断)，进入同步代码块，
        这个时候，我们如果不加入第二次判断的话，那么线程A又会创造一个实例singleton，就不满足我们的单例模式的要求，所以第二次判断是很有必要的。*/
public class DoubleSingleton {
    private static DoubleSingleton ds;

    public static DoubleSingleton getInstance(){
        if(ds==null){
            synchronized (DoubleSingleton.class){
                if(ds==null){
                    ds=new DoubleSingleton();
                }
            }
        }
        return ds;
    }
}
