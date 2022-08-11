package ex1.analyser;

import java.util.List;

public abstract sealed class AbstractTaxSalesAnalyser permits FlatTaxSalesAnalyser, TaxFreeSalesAnalyser, DifferentiatedTaxSalesAnalyser {
    protected List<SalesRecord> rec;


    public AbstractTaxSalesAnalyser(List<SalesRecord> records) {
        rec = records;
    }

    protected Double getTotalSales(){
        Double sum = 0.0;
        Double reducedSum = 0.0;

        if(getTaxRate() == 1.2 || getTaxRate() == 1.0) {
            for (SalesRecord record : rec) {

                sum += record.getProductPrice() * record.getItemsSold();

                System.out.println(sum + "normal tax");
            }


        }
        if(getTaxRate() == 1.1) {
            for (SalesRecord record : rec) {
                if (record.hasReducedRate()) {
                    reducedSum += record.getProductPrice() * record.getItemsSold();
                    System.out.println(reducedSum + "reduced tax");
                } else {
                    sum += record.getProductPrice() * record.getItemsSold();

                    System.out.println(sum + "normal tax");
                }


            }
        }
        System.out.println(sum);
        System.out.println(reducedSum);
        System.out.println(getTaxRate());
        reducedSum = reducedSum / getTaxRate();
        if(reducedSum > 0.0){
            return sum / 1.2 + reducedSum;
        }
        sum = sum / getTaxRate();


        return sum;

    }

    public Double getTotalSalesByProductId(String id) {

        Double count = 0.0;
        for (SalesRecord record : rec) {
            if (id == record.getProductId()) {
                count += record.getProductPrice() * record.getItemsSold();

            }
        }


        return count / getTaxRate();
    }

    public String getIdOfMostPopularItem() {
        String nameOfCurrent = rec.get(0).getProductId();
        Integer soldOfCurrent = rec.get(0).getItemsSold();
        for (SalesRecord record : rec) {
            if (record.getItemsSold() > soldOfCurrent) {
                soldOfCurrent = record.getItemsSold();
                nameOfCurrent = record.getProductId();
            }
        }

        return nameOfCurrent;


    }

    public String getIdOfItemWithLargestTotalSales() {
        String nameOfCurrent = rec.get(0).getProductId();
        Double totalProfit = Double.valueOf(rec.get(0).getProductPrice()) * Double.valueOf(rec.get(0).getItemsSold());
        Double count = 0.0;
        int i = 0;
        while (i < rec.size()) {
            if (count > totalProfit) {
                totalProfit = count;
                nameOfCurrent = rec.get(i - 1).getProductId();

            }
            for (SalesRecord record2 : rec) {
                if (rec.get(i).getProductId() == record2.getProductId()) {
                    count = Double.valueOf(record2.getProductPrice()) * Double.valueOf(record2.getItemsSold());
                }
            }
            i++;
        }
        return nameOfCurrent;
    }
    abstract protected Double getTaxRate();

}
