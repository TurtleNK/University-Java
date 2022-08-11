package ex1.customer;

import java.time.LocalDate;
import java.time.temporal.ChronoField;


public final class RegularCustomer extends AbstractCustomer {
   private LocalDate lastOrderedDate;

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints);


        this.lastOrderedDate = lastOrderDate;

    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        if(order.getDate().getDayOfYear() - Integer.valueOf(this.lastOrderedDate.getDayOfYear()) >= 0 && Integer.valueOf(order.getDate().getDayOfYear()) - Integer.valueOf(this.lastOrderedDate.getDayOfYear()) <= 31 && order.getTotal() >= 100  ){
            System.out.println("aa");
            bonusPoints += Double.valueOf(order.getTotal() * 1.5).intValue();
//            System.out.println(this.getBonusPoints());
        }else if(order.getTotal() >= 100 ){
            bonusPoints += 200;

            System.out.println(order.getDate().get(ChronoField.DAY_OF_YEAR));
            System.out.println(LocalDate.of(2022, 4, 7).get(ChronoField.DAY_OF_YEAR));
            System.out.println(LocalDate.of(2022, 4, 6).get(ChronoField.DAY_OF_YEAR));
            System.out.println(order.getDate().getDayOfYear());
            System.out.println(order.getDate().minusMonths(1));
            System.out.println(Integer.valueOf(order.getDate().getDayOfYear()) - Integer.valueOf(this.lastOrderedDate.getDayOfYear()));


//

        }
        System.out.println(this.getBonusPoints());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RegularCustomer order){
            return id.equals(order.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public String asString() {
        return String.format("REGULAR;%s;%s;%s;%s", id, name, bonusPoints, lastOrderedDate);
    }



}