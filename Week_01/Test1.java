/**
 * 
 */
package com.ling.day1;

import java.lang.reflect.Method;

/**
 * 
 * @Author: ljg 2021年1月9日 下午12:14:15
 * 
 * @Desc: <p>
 * </p>
 */
public class Test1 {
    public static void main(String[] args) {
        MyClassLoader my = new MyClassLoader();
        try {
            Class<?> obj = my.getMyClass("Hello");
            Method m = obj.getMethod("hello");
            m.invoke(obj.newInstance());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
