package ex1.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractTaxSalesAnalyser {

    private static final Double TAX_RATE = 1.0;

    protected TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }


    @Override
    protected Double getTaxRate() {
        return TAX_RATE;
    }
}
