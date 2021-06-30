package org.example.p20200623;

public class Student {
    private String name;
    private int age;
    public String book;

    Student(String name){
        this.name = name;
        System.out.println("这是默认的构造方法");
    }
    public Student(){
        System.out.println("这是共有的无参构造方法");
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("这是一个共有的多参构造方法");
    }
    protected Student(boolean n){
        System.out.println("这是一个受保护的构造方法");
    }
    private Student(int age){
        this.age = age;
        System.out.println("这是一个受保护的构造方法");
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public String getBook(){
        return this.book;
    }

    public void setBook(String book){
        this.book = book;
    }

    public void show(){
        System.out.println("调用了 共有的 无返回参数 无入参 的show方法");
    }

    public void show1(String s){
        System.out.println("调用了 共有的 无返回参数 String入参 的show1方法 s="+s);
    }

    protected void show2(){
        System.out.println("调用了 受保护的 无返回参数 无入参 的show2方法");
    }

    void show3(){
        System.out.println("调用了 默认的 无返回参数 无入参 的show3方法");
    }

    private String show4(int age){
        System.out.println("调用了 私有的 字符串返回参数 int入参 的show4方法 age="+age);
        return "";
    }

    public void showBook(){
        System.out.println("我的书名字叫"+book);
    }
}