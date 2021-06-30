package org.example.p20200623.wangtao;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;
import org.example.p20200623.Student;

public class Wangtao {

    public void process(){
        //System.out.println(Student.class.getName());
        try{
            /*这是获取构造方法的代码块*/
            Class<?> clazz = Class.forName("org.example.p20200623.Student");
            //所有共有构造方法
            Constructor<?>[] conArr = clazz.getConstructors();
            for(Constructor<?> c : conArr){
                System.out.println(c);
            }
            System.out.println("------");
            //所有的构造方法
            conArr = clazz.getDeclaredConstructors();
            for(Constructor<?> c : conArr){
                System.out.println(c);
            }
            System.out.println("--------");
            //获取一个的共有无参的构造方法
            Constructor<?> c = clazz.getConstructor(String.class,int.class);
            c.setAccessible(true);
            Student obj = (Student) c.newInstance("d",9);
            System.out.println(obj.getName()+obj.getAge());
            //System.out.println(c);
            /*这是获取成员变量并调用的代码块*/

            //获取所有共有字段
            Field[] fArray1 = clazz.getFields();

            //获取所有字段
            Field[] fArray2 = clazz.getDeclaredFields();

            //获取某个共有字段
            Field f1 = clazz.getField("book");
            System.out.println(f1);
            f1.set(obj,"吴彦的书记");
            System.out.println(obj.getBook());

            /*这是获取成员方法的代码块*/
            //所有的共有的成员方法
            Method[] m1Arr = clazz.getMethods();
            //所有的成员方法
            Method[] m2Arr = clazz.getDeclaredMethods();
            //获取某个成员方法
            Method m3 = clazz.getMethod("show1", String.class);
            m3.invoke(obj,"李天一");
            //获取某个私有的成员方法
            Method m4 = clazz.getDeclaredMethod("show4", int.class);
            m4.setAccessible(true);
            m4.invoke(obj,99);

            File dic = new File("");
            System.out.println();
            //获取配置文件
            Properties pro = new Properties();
            FileReader in = new FileReader(dic.getCanonicalPath()+"/src/main/resources/pro");
            pro.load(in);
            in.close();
            Class<?> classStudent = Class.forName(pro.getProperty("className"));
            Method m = classStudent.getMethod(pro.getProperty("methodName"),String.class);
            m.invoke(classStudent.getConstructor().newInstance(),"fsdfdsfds");

            //通过反射越过泛型检查
            ArrayList<String> strList = new ArrayList<String>();
            strList.add("aa");
            strList.add("bb");
            Class<?> listClass = strList.getClass();
            Method m9 = listClass.getMethod("add",Object.class);
            m9.invoke(strList,100);
            for(Object objTemp : strList){
                System.out.println(objTemp);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | IOException e){
            e.printStackTrace();
        }
    }

    public void practice1()  {
        try {
            Class<?> cla = Class.forName("org.example.p20200623.Student");
            Constructor<?> con = cla.getConstructor(String.class,int.class);
            Object obj = (Student)con.newInstance("李天一",18);
            Field fie = cla.getField("book");
            fie.set(obj,"php开发大全");
            Method met = cla.getMethod("showBook");
            met.invoke(obj);
        }catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchFieldException e){
            e.printStackTrace();
        }

    }
}
