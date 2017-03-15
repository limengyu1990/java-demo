package org.test;

import java.io.UnsupportedEncodingException;
import java.io.ObjectInputStream.GetField;
import java.net.URLDecoder;

public class TestThread {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();
//        thread1.start();
//        thread2.start();
        
        System.out.println(URLDecoder.decode("%E5%90%95"));
        String oo = new String("???S".getBytes("ISO-8859-1"), "UTF-8");
       System.out.println(oo);
        String name  = new String("%E5%90%95".getBytes("ISO-8859-1"),"GBK");  
        System.out.println(name);
        
//        String s= "192.168.234.1 - - [28/Mar/2014:09:18:49 +0800] \"GET /cms/search/search.do?query=%E5%90%95 HTTP/1.1\" 404 1069";
//        String second = s.split("\"")[1];  
//        System.out.println(second);
//        int t = second.split(" ").length;
//        System.out.println(t);
//        for(int i=0;i<t;i++){
//            System.out.println(second.split(" ")[i]);
//        }
//        String r = second.split(" ")[1];
//        System.out.println(r+"=====");
//        r = r.replace("/cms/search/search.do?query=","");
        
        
//       int n = Thread.activeCount();
//       System.out.println("active count :"+n);
//       
//       Thread array[] = new Thread[n];
//       Thread.enumerate(array);
//       System.out.println("Active thread:" );
//       for(int i=0;i<array.length;i++){
//           System.out.println(array[i].getName());
//       }
       
    }
}
