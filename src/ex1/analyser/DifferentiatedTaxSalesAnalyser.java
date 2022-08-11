package ex1.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractTaxSalesAnalyser {
    private static final Double TAX_RATE = 1.1;

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }


    @Override
    protected Double getTaxRate(){
        return TAX_RATE;
    }


}
