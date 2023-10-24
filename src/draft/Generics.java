package draft;

import java.util.Arrays;

public class Generics {

    public static class BlackHole <T>{
        private T value;

        public BlackHole(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BlackHole<String> blackHole;
        BlackHole<String> blackHole1 = new BlackHole<>("gg");

        blackHole1.setValue("12312 is good!");

        String str1 = blackHole1.getValue();
        StringBuilder sb = new StringBuilder(str1);

        System.out.println(sb);
//        System.out.println(blackHole1.getValue());
    }




}
