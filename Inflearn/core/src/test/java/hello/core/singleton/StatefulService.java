package hello.core.singleton;

public class StatefulService {

    // private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        // this.price = price; // 여기가 문제!

        return price; // 지역 변수를 통해 무상태로 만들기, 값을 유지할 필요가 없음
    }

}
