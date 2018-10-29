package com.jclass.util;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class ChangeMethod {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //设置目标类的路径
        pool.insertClassPath("/Users/huhao/Desktop/DOC/bigRLossWarn/") ;
        //获得要修改的类
        CtClass cc =pool.get("bigRLossWarn.core.BigRLossWarn$");//就是对Login.class的映射
        //得到方法
        CtMethod m = cc.getDeclaredMethod("main");
        //可以在函数的开头插入新的代码
        //m.insertBefore("{return true;}") ;
        //也可以直接将verify函数的内容设为return true;至于功能你懂的

        String a = "conf.set('spark.es.net.http.auth.user','liveme_big_data_dev').set('spark.es.net.http.auth.pass','i89kpchvlfy58u1no6wogtdyl2pve29');\n".replace("'","\"");

        m.insertAt(64,a);

        //保存到文件里,会在项目根目录下生成一个Login.class,并没有自动替换classes/Login.class，需要自己手动替换进去
        cc.writeFile() ;

        // 调用测试
//        Object o=cc.toClass().newInstance();
//        Method verify=o.getClass().getDeclaredMethod("verify");
//        System.out.println(verify.invoke(o));

    }




}
