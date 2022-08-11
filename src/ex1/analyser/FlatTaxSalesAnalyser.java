package ex1.analyser;


import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractTaxSalesAnalyser {
    private static final Double TAX_RATE = 1.2;

    protected FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);

    }

    @Override
    protected Double getTaxRate(){
        return TAX_RATE;
    }


}
