package ex1.cart;

import java.util.*;

public class ShoppingCart<T extends CartItem> {

    private final Map<T, Integer> itemsMap = new TreeMap<>(new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.getId().charAt(1) - o2.getId().charAt(1);
        }
    });

    private final List<Double> discountList = new ArrayList<>();


    public void add(T item) {
        if (itemsMap.containsKey(item)) {
            itemsMap.put(item, itemsMap.get(item) + 1);
        } else {
            itemsMap.put(item, 1);
        }
    }

    public void removeById(String id) {
        for (T item : itemsMap.keySet()) {
            if (item.getId().equals(id)) {
                itemsMap.remove(item);
            }
        }
    }

    public Double getTotal() {
        Double sum = 0.0;
        for (T item : itemsMap.keySet()) {
            sum += item.getPrice() * itemsMap.get(item);
        }
        if (!discountList.isEmpty()) {
            for (Double discount : discountList) {
                sum = sum - (sum * discount / 100);
            }
        }
        return sum;
    }

    public void increaseQuantity(String id) {
        for (T t : itemsMap.keySet()) {
            if (t.getId().equals(id)) {
                itemsMap.put(t, itemsMap.get(t) + 1);
            }
        }
    }

    public void applyDiscountPercentage(Double discount) {
        discountList.add(discount);
    }

    public void removeLastDiscount() {
        discountList.remove(discountList.size() - 1);
    }

    public void addAll(List<? extends T> items) {
        for (T item : items) {
            add(item);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : itemsMap.keySet()) {
            int amount = itemsMap.get(element);
            sb.append(String.format("(%s, %s, %s), ", element.getId(), element.getPrice(), amount));
        }
        int indexOfJunk = sb.lastIndexOf(",");
        sb.replace(indexOfJunk, sb.length(), "");
        return sb.toString();
    }

}


