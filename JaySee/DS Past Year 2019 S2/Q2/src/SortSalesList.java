import java.util.ArrayList;
import java.util.Collections;

class SalesList{
    private String area;
    private String salesRep;
    private int amount;

    public SalesList(){}

    public SalesList(String area, String salesRep, int amount){
        this.area = area;
        this.salesRep = salesRep;
        this.amount = amount;
    }

    public String getArea(){return area;}

    public String getSalesRep(){return salesRep;}

    public int getAmount(){return amount;}

    @Override
    public String toString(){
        return String.format("%-12s%-4d%s", area, amount, salesRep);
    }
}

class SortSalesList{
        public static void selectionSortRegion(ArrayList<SalesList> salesList) {
            for (int i = 0; i < salesList.size() - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < salesList.size(); j++) {
                    if (salesList.get(j).getArea().compareTo(salesList.get(maxIndex).getArea()) > 0) {
                        maxIndex = j;
                    }
                }
                Collections.swap(salesList, i, maxIndex);
            }
        }
    
        public static void insertionSortSalesAmount(ArrayList<SalesList> salesList) {
            for (int i = 1; i < salesList.size(); i++) {
                SalesList current = salesList.get(i);
                int j = i - 1;
                while (j >= 0 && salesList.get(j).getAmount() > current.getAmount()) {
                    salesList.set(j + 1, salesList.get(j));
                    j--;
                }
                salesList.set(j + 1, current);
            }
        }
    
        public static void bubbleSortSalesRep(ArrayList<SalesList> salesList) {
            boolean swapped;
            for (int i = 0; i < salesList.size() - 1; i++) {
                swapped = false;
                for (int j = 0; j < salesList.size() - 1 - i; j++) {
                    if (salesList.get(j).getSalesRep().compareTo(salesList.get(j + 1).getSalesRep()) > 0) {
                        Collections.swap(salesList, j, j + 1);
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
        }

        public static void main(String[] args) {
            ArrayList<SalesList> salesData = new ArrayList<>();
            salesData.add(new SalesList("Asia", "Ahmad", 450));
            salesData.add(new SalesList("Europe", "Hemish", 518));
            salesData.add(new SalesList("Europe", "Banny", 650));
            salesData.add(new SalesList("Greenland", "Ain", 200));
            salesData.add(new SalesList("Asia", "Ali", 390));
            salesData.add(new SalesList("Greenland", "Ben", 670));
            salesData.add(new SalesList("Asia", "Lee", 796));
            System.out.println("Original Data: ");
            for (SalesList s : salesData) {
                System.out.println(s);
            }
    
            selectionSortRegion(salesData);
            System.out.println("\nSorting Result on Region using SelectionSort:");
            for (SalesList s : salesData) {
                System.out.println(s);
            }
    
            insertionSortSalesAmount(salesData);
            System.out.println("\nSorting Result on Sales Amount using InsertionSort:");
            for (SalesList s : salesData) {
                System.out.println(s);
            }
    
            bubbleSortSalesRep(salesData);
            System.out.println("\nSorting Result on SalesRep using BubbleSort:");
            for (SalesList s : salesData) {
                System.out.println(s);
            }
        }
}