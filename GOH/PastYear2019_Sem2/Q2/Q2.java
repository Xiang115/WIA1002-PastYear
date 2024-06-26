package GOH.PastYear2019_Sem2.Q2;

public class Q2 {
    public static void main(String[] args) {
        SalesList[] dataList = {
                new SalesList("Asia", 450, "Ahmad"),
                new SalesList("Europe", 518, "Hemish"),
                new SalesList("Europe", 650, "Banny"),
                new SalesList("Greenland", 200, "Ain"),
                new SalesList("Asia", 390, "Ali"),
                new SalesList("Greenland", 670, "Ben"),
                new SalesList("Asia", 790, "Lee"),
        };

        System.out.println("Original Data:");
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println("");

        System.out.println("Sorting Result on Region using SelectionSort:");
        SortSalesList.SortRegion(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Sorting Result on Sales using InsertionSort:");
        SortSalesList.SortAmount(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Sorting Result on SalesRep using BubbleSort:");
        SortSalesList.SortRepresentative(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();
    }
}