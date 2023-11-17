package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(getBy("증정 이벤트"));
    }

    public static List<EnumModel> values() {
        return Stream.of(Discount.getDiscounts(), Gift.getGifts())
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static EnumModel getBy(String name) {
        return values().stream().filter(enumModel -> enumModel.getEventName().equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);

    }

}
