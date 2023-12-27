package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumTest {
    public static void main(String[] args) {
        Map<EnumModel, Integer> map = new HashMap<>();
        map.put(Discount.CHRISTMAS_D_DAY, 1);
        System.out.println(map.containsKey(Discount.CHRISTMAS_D_DAY));
        char z = 'Z';
        System.out.println((int) z);
    }

    public static List<EnumModel> values() {
        return Stream.of(Discount.getDiscounts(), Gift.getGifts())
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static EnumModel getBy(String name) {
        return values().stream().filter(enumModel -> enumModel.getEventName().equals(name)).findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }

}
