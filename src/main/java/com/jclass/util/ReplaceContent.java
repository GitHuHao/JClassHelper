package com.jclass.util;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.Constant;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ReplaceContent {
    public static void main(String[] args) throws Exception {

        String filePath = "/Users/huhao/Desktop/DOC/bigRLossWarn/bigRLossWarn/core/BigRLossWarn$.class";//新建的需要進行操作的文件夾
        FileInputStream fis = new FileInputStream(filePath);

        DataInput di = new DataInputStream(fis);
        ClassFile cf = new ClassFile();
        cf.read(di);
        Constant[] infos = cf.getConstantPool();

        int count = infos.length;
        for (int i = 0; i < count; i++) {
            if (infos[i] != null) {
                System.out.print(i);
                System.out.print(" = ");
                System.out.print(infos[i].getVerbose());
                System.out.print(" = ");
                System.out.println(infos[i]);
                if(i == 158){
                    ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
                    uInfo.setString("10.66.202.187");
                    infos[i]=uInfo;
                }
            }
        }
        cf.setConstantPool(infos);
        fis.close();
        File f = new File(filePath);
        ClassFileWriter.writeToFile(f, cf);
    }
}
