参照：https://blog.csdn.net/liufang1991/article/details/59103589

1.下载安装 jclass-lib
    jclaslib bytecode viewer

2.从jclaslib 安装lib包中定位依赖jar,添加到项目依赖中
    annotations-13.0.jar
    idea-5.2.jar
    install4j-runtime-6.1.4.jar
    jclasslib-browser.jar
    jclasslib-library.jar
    kotlin-stdlib-1.1.3-2.jar
    kotlinx.dom-0.0.10.jar
    miglayout-core-5.0.jar
    miglayout-swing-5.0.jar

应用场景1：内容替换
1）解压jar,提取需要修改字节码的.class 文件，使用jclaslib bytecode viewer查看需要替换的内容的编号
    使用 ReplaceContent 执行替换

2）使用新 .class  文件替换旧jar的 class 文件

应用场景2：插入新内容
1).参照ChangeMethod

2).新生成的class文件直接写出到本项目的跟路径下，手动完成替换即可


