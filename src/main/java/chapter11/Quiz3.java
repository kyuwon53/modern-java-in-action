package chapter11;

import java.util.Optional;
import java.util.Properties;

public class Quiz3 {
    /*
    *  public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
            }
        }
        return 0;
    }
    *
    * 위의 코드를 Optional과 유틸리티 메소드를 이용해 하나의 유연한 코드로 재구현 하라
    * */

    public static int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(Quiz3::stringToUnsignedInt)
                .orElse(0)
                ;
    }

    public static Optional<Integer> stringToUnsignedInt(String text) {
        try {
            return Optional.of(Integer.parseUnsignedInt(text));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
