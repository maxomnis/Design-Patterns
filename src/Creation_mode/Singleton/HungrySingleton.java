package Creation_mode.Singleton;

/**
 * @ClassName SingletonLazy
 * @Description 饿汉式单例
 *   该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
 *   饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 * @Author zhangjun
 * @Date 2021/11/25 17:36
 * @Version 1.0
 */
public class HungrySingleton {
    public static void main(String[] args) {
        President zt1 = President.getInstance();
        zt1.getName();    //输出总统的名字
        President zt2 = President.getInstance();
        zt2.getName();    //输出总统的名字
        if (zt1 == zt2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}

class President2 {
    private static  President2 instance = new President2();  //President2类第一次被加载时，已经被创建
    private President2() {
        System.out.println("产生一个总统！");
    }
    public static  President2 getInstance() {
        if (instance == null) {
            instance = new President2();
        } else {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }
    public void getName() {
        System.out.println("我是美国总统：特朗普。");
    }
}