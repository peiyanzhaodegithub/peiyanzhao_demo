package com.example.demo.proxy;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 10:51
 * @Description: TODO
 */
public class TestProxy {

    /**
      * @Description: 实际上helloReflect2.helloReflect();方法就是调用了代理生成的class文件中invoke方法
      * @DateTime: 2021/6/15 14:25
      * @Params: 
      * @Return
      */
    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");//将生成的代理类的字节码文件保存到本地，后面分析原理会用到
        HelloReflect helloReflect1=new HelloReflectImpl();
        Class<?>[] arr=helloReflect1.getClass().getInterfaces();
        for(Class clazz:arr){
            System.out.println(clazz.getName());
        }
        HelloReflect helloReflect2=new JDKProxy(helloReflect1).getProxy();
        helloReflect2.helloReflect();
    }


}
