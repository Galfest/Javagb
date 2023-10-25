package com.gb.java.classwork.l3;

import java.util.ArrayList;

public class Main {

    private static class Box{
        private Object obj;
        public Box (Object obj){
            this.obj = obj;
        }
        public Object getObj(){
            return obj;
        }
        public void setObj(Object obj){
            this.obj = obj;
        }
        public void printInfo(){
            System.out.printf("Box (%s): %s", obj.getClass().getSimpleName(), obj.toString());
        }

    }

    public static <T> void copyTo(ArrayList<? extends T> src, ArrayList<? super T> dst){
        for (T o : src){
            dst.add(o);
        }
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);

        b1.setObj(100111);

        System.out.println(b1.getClass());
        System.out.println(b1.getObj());
        b1.printInfo();
//        System.out.println(b1.getObj(), + b2.getObj());
    }
}
