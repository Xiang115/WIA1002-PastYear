package GOH.PastYear2019_Sem2.Q2;

public class SalesList {
    String Region;
    int Sales;
    String RepresentativeName;
    
    public SalesList(){
        Region = RepresentativeName = null;
        Sales = 0;
    }
    
    public SalesList(String Region, int Sales, String RepresentativeName){
        this.Region = Region;
        this.Sales = Sales;
        this.RepresentativeName = RepresentativeName;
    }
    
    @Override
    public String toString(){
        return String.format("%-20s %-5d %-20s", Region, Sales, RepresentativeName);
    }
}
