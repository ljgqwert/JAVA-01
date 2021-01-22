/**
 * 
 */
package com.ling.day1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * @Author: ljg 2021年1月7日 下午9:01:17
 * 
 * @Desc: <p>
 * </p>
 */
public class MyClassLoader extends ClassLoader {
    /**
     * 
     * @Author ljg 2021年1月9日 下午1:00:07
     * @param name
     * @return
     * @throws Exception
     */

    public Class<?> getMyClass(String name) throws Exception {
        byte[] temp = getClassByte(name);
        return defineClass(name, temp, 0, temp.length);
    }

    /**
     * 
     * @Author ljg 2021年1月9日 下午1:00:15
     * @return
     * @throws Exception
     */
    public byte[] getClassByte(String fileName) throws Exception {
        // String path = this.getClass().getResource("/").getPath();
        // fileName = fileName.replace(".", "//");
        // FileInputStream in = new FileInputStream(new File(path + fileName + ".class"));

        File file = new File("D:/hello/hello.xlass");
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int content = 0;
        while ((content = in.read()) != -1) {
            byteArrayOutputStream.write(255 - content);
        }
        in.close();
        return byteArrayOutputStream.toByteArray();
    }

    public void createXClass(String fileName) throws Exception {
        String path = this.getClass().getResource("/").getPath();
        fileName = fileName.replace(".", "//");
        FileInputStream in = new FileInputStream(new File(path + fileName + ".class"));
        int k = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((k = in.read()) != -1) {
            byteArrayOutputStream.write(255 - k);
        }
        FileOutputStream out = new FileOutputStream(new File("d:/hello/hello.xclass"));
        out.write(byteArrayOutputStream.toByteArray());
        out.close();
        in.close();
    }

    public static void main(String[] args) {
        MyClassLoader my = new MyClassLoader();
        try {
            my.createXClass("com.ling.day1.Hello");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
