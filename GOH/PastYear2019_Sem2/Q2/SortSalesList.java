package GOH.PastYear2019_Sem2.Q2;

public class SortSalesList {

    public SortSalesList() {

    }

    //selection sort (descending)
    public static void SortRegion(SalesList[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            String max = list[i].Region;
            int maxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                String other = list[j].Region;
                if (max.compareTo(other) < 0) {
                    max = other;
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                swap(list, i, maxIndex);
            }
        }
    }

    //insertion sort (ascending)
    public static void SortAmount(SalesList[] list) {
        for (int i = 1; i < list.length; i++) {
            SalesList min = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j].Sales > min.Sales; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = min;
        }
    }

    //bubble sort (ascending)
    public static void SortRepresentative(SalesList[] list) {
        boolean tf = true;
        for (int i = 0; i < list.length - 1 && tf; i++) {
            tf = false;
            for (int j = 1; j < list.length; j++) {
                if(list[j-1].RepresentativeName.compareTo(list[j].RepresentativeName)>0){
                    tf = true;
                    swap(list,j,j-1);
                }
            }
        }
    }

    public static void swap(SalesList[] list, int i, int j) {
        SalesList temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
