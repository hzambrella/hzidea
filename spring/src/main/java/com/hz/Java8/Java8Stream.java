package com.hz.Java8;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Stream {

    public static void main(String[]args){
        new Java8Stream().try1();
        new Java8Stream().tryForEach();
        new Java8Stream().changeType();
    }

    private void changeType(){
        int[] result=IntStream.of(1,10).map((i)->i*2).toArray();
        //int[]转Integer[]
        Integer[] integerRes=IntStream.of(result).boxed().toArray(Integer[]::new);
        //boxed可以装箱，将IntStream转为Stream<Integer>
        //Integer转int
        result=Arrays.stream(integerRes).mapToInt(Integer::valueOf).toArray();
        //mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream

        //Integer转list Arrays.asList
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,integerRes);
        //List转Integer
        integerRes= (Integer[]) list.toArray(new Integer[0]);

        //int转list
        list=IntStream.of(result).boxed().collect(Collectors.toList());
        //list转int
        result=list.stream().mapToInt(Integer::valueOf).toArray();

    }

    private void try1(){
        Integer limitStatus=30;
        List<OrderHeader> headers=new ArrayList<>();
        for (int i=0;i<10;i++){
            headers.add(new OrderHeader(i*10,String.valueOf(i)));
        }
        List<String>ordernos=headers.stream().map(s->new OrderHeader(s.status,"hz"+s.orderno)).
                filter(s->s.status<limitStatus).map(obj->obj.orderno).collect(Collectors.toList());
        System.out.println(ordernos.stream().collect(Collectors.joining(",")));
    }

    private void tryForEach(){
        Integer[]array=new Integer[]{1,3,6,7,0,9,2};
        List<Integer>list= new ArrayList<>();
        Collections.addAll(list,array);
        list.stream().forEach(s->s=s+1);//没有改变
        System.out.println(list.stream().map(s->String.valueOf(s)).collect(Collectors.joining(", ")));

        String[]array2=new String[]{"1","2"};
        List<String>list2= new ArrayList<>();
        Collections.addAll(list2,array2);
        list2.stream().forEach(s->s=s+"1");//没有变化
        System.out.println(list2.stream().map(s->String.valueOf(s)).collect(Collectors.joining(", ")));


        List<OrderHeader> headers=new ArrayList<>();
        for (int i=0;i<4;i++){
            headers.add(new OrderHeader(i*10,String.valueOf(i)));
        }
        System.out.println(JSON.toJSONString(headers));
        headers.stream().forEach(s->s.status=s.status+1);
        System.out.println(JSON.toJSONString(headers));//变了
    }

    class OrderHeader{
        int status;
        String orderno;
        OrderHeader(){

        }
        OrderHeader(int status,String orderno){
            this.status=status;
            this.orderno=orderno;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }
    }
}
