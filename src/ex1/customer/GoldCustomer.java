package ex1.customer;

public final class GoldCustomer extends AbstractCustomer {

    public GoldCustomer(String id, String name, int bonusPoints ) {
        super(id, name, bonusPoints);
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        bonusPoints += Double.valueOf(order.getTotal() * 1.5).intValue();
        System.out.println(this.getBonusPoints());
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public String asString() {
        return String.format("GOLD;%s;%s;%s;", id, name, bonusPoints);
    }

}