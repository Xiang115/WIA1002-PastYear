/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q4 {
    public static void main(String[] args) {
        MyHashMap myHashMap=new MyHashMap();
        
        System.out.println("New directory entry: ");
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-22740000");
        myHashMap.put("TonyS", "0119-4550800");
        myHashMap.put("LaraC", "014-6402009");
        System.out.println("");
        
        System.out.println("Get directory: ");
        Entry e1=myHashMap.get("DeanW");
        System.out.println("DeanW: "+e1.getValue());
        Entry e2=myHashMap.get("BruceW");
        System.out.println("BruceW: "+e2.getValue());
        System.out.println("");
        
        System.out.println("Update directory: ");
        myHashMap.put("BruceW", "011-5677900");
        myHashMap.put("JeanG", "019-9001123");
        
        Entry e3=myHashMap.get("BruceW");
        System.out.println("BruceW: "+e3.getValue());
        Entry e4=myHashMap.get("JeanG");
        System.out.println("JeanG: "+e4.getValue());
    }
}

class MyHashMap<E>{
    private E[] key;
    private E[] value;
    private int size;
    private int count=0;
    
    public MyHashMap(){
        size=10;
        key=(E[])new Object[size];
        value=(E[])new Object[size];
    }
    
    public MyHashMap(E keys,E values){
        size=10;
        key=(E[])new Object[size];
        value=(E[])new Object[size];
        key[count]=keys;
        value[count]=values;
        count++;
    }
    
     public void put(E keys, E values) {
        for (int i = 0; i < count; i++) {
            if (key[i].equals(keys)) {
                value[i] = values;
                return;
            }
        }

        if (count == size){
            resize();
        }
        key[count] = keys;
        value[count] = values;
        count++;
    }
     
     private void resize(){
        size *= 2;
        E[] newKeys = (E[]) new Object[size];
        E[] newValues = (E[]) new Object[size];

        for(int i=0;i<count;i++){
            newKeys[i]=key[i];
            newValues[i]=value[i];
        }
        
        key=newKeys;
        value=newValues;
    }
    
    public Entry get(E input){
        int pointer=0;
        while(key[pointer]!=null){
            if(key[pointer].equals(input)){
                return new Entry(value[pointer]);
            }
            pointer++;
        }
        return null;
    }
}

class Entry<E>{
    private E item;
    
    public Entry(E e){
        item=e;
    }
    
    public E getValue(){
        return item;
    }
}