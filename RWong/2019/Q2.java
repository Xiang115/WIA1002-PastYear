/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WIA1002;

/**
 *
 * @author HP
 */
public class Q2 {
    public static void main(String[] args) {
        SalesList[] list=new SalesList[7];
        list[0]=new SalesList("Asia",450,"Ahmad");
        list[1]=new SalesList("Europe",518,"Hemish");
        list[2]=new SalesList("Europe",650,"Banny");
        list[3]=new SalesList("Greenland",200,"Ain");
        list[4]=new SalesList("Asia",390,"Ali");
        list[5]=new SalesList("Greenland",670,"Ben");
        list[6]=new SalesList("Asia",790,"Lee");
        System.out.println("Original data:");
        for(SalesList lists:list){
            System.out.println(lists.toString());
        }
        System.out.println();
        
        SortSalesList updated=new SortSalesList();
        updated.selectionSort(list);
        System.out.println("Sorting Result on Region using SelectionSort:");
        for(SalesList lists:list){
            System.out.println(lists.toString());
        }
        System.out.println();
        
        updated.insertionSort(list);
        System.out.println("Sorting Result on Sales using InsertionSort:");
        for(SalesList lists:list){
            System.out.println(lists.toString());
        }
        System.out.println();
        
        updated.bubbleSort(list);
        System.out.println("Sorting Result on SalesRep using BubbleSort:");
        for(SalesList lists:list){
            System.out.println(lists.toString());
        }
    }
}

class SalesList{
    private String region;
    private int result;
    private String SalesRep;

    public SalesList(String region, int result, String SalesRep){
        this.region=region;
        this.result=result;
        this.SalesRep=SalesRep;
    }

    public SalesList(){
        this("North America",999,"John Doe");
    }

    @Override
    public String toString(){
        String s=String.format("%-12s%-4d%s",region,result,SalesRep);
        return s;
    }

    public String getRegion(){
        return region;
    }

    public int getResult(){
        return result;
    }

    public String getSalesRep(){
        return SalesRep;
    }
}

class SortSalesList{
    public void selectionSort(SalesList[] list){
        for(int i=0;i<list.length;i++){
            SalesList maxRegion=list[i];
            int maxindex=i;

            for(int j=i;j<list.length;j++){
                if(maxRegion.getRegion().compareTo(list[j].getRegion())<0){
                    maxRegion=list[j];
                    maxindex=j;
                }
            }

            if(maxindex!=i){
                list[maxindex]=list[i];
                list[i]=maxRegion;
            }
        }
    }

    public void insertionSort(SalesList[] list){
        for(int i=0;i<list.length;i++){
            SalesList currentSales=list[i];
            int k;
            for(k=i-1;k>=0 && list[k].getResult()>currentSales.getResult();k--){
                list[k+1]=list[k];
            }
            list[k+1]=currentSales;
        }
    }

    public void bubbleSort(SalesList[] list){
        boolean neednextpass=true;
        for(int k=1;k<list.length && neednextpass;k++){
            neednextpass=false;
            for(int i=0;i<list.length-k;i++){
                if(list[i].getSalesRep().compareTo(list[i+1].getSalesRep())>0){
                    SalesList temp=list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    neednextpass=true;
                }
            }
        }
    }
}