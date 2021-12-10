package Structural_model.Proxy;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author zhangjun
 * @Date 2021/12/3 17:14
 * @Version 1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
        //Proxy1 proxy = new Proxy1();

        Proxy2 proxy = new Proxy2();

        proxy.Request();
    }
}
//抽象主题
interface Subject {
    void Request();
}
//真实主题
class RealSubject implements Subject {
    @Override
    public void Request() {
        System.out.println("访问真实主题方法...");
    }
}
//代理
class Proxy1 implements Subject {
    private RealSubject realSubject;
    @Override
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest() {
        System.out.println("Proxy1 访问真实主题之前的预处理。");
    }
    public void postRequest() {
        System.out.println("Proxy1 访问真实主题之后的后续处理。");
    }
}


//代理
class Proxy2 implements Subject {
    private RealSubject realSubject;
    @Override
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest() {
        System.out.println("Proxy2 访问真实主题之前的预处理。");
    }
    public void postRequest() {
        System.out.println("Proxy2 访问真实主题之后的后续处理。");
    }
}