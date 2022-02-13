package optional;

import java.util.*;

public class OptionalStudy {

    public static void main(String[] args) {

        /*
        .of는 내부에 값이 없으면 nullPointException이 발생
        절대 null이 들어오지 않는다는 보장을 가지고 써야한다.
         */
        Optional<String> ofResult = Optional.of("cat");

        /*
        null 값이 들어오면 Optional.Empty를 반환한다.
        옵셔널 만들때 안전한 방법
         */
        Optional<String> ofNullableResult = Optional.ofNullable("dog");

        /*
        .get()도 null이 들어올 가능성이 전혀 없다는 가정 하에 써야한다.
        null값일시 noSuchElementException 발생한다.
         */
        String getResult = ofNullableResult.get();

        /*
        orElse()는 값이 없을 시 noSuchElementException이나 NPE를 터트리는 대신 디폴트값을 반환한다.
         */
        String orElseResult = ofNullableResult.orElse("default");

        /*
        orElseGet()은 값이 없을 시 람다식을 반환한다.
        중요! orElse와 orElseGet의 차이 :
            - orElse는 null값의 유무와 상관없이 무조건 디폴트값을 생성한다.
            - orElseGet은 null값이 들어올때만 람다를 통해 디폴트값을 생성한다.
            * 문자는 상관없지만 객체의 경우에는 성능상에 문제가 될 수 있다. 미리 생성한 객체를 사용하던지 하자.
         */
        String orElseGetResult = ofNullableResult.orElseGet(() -> "default");

        /*
        null값이 들어있다면 예외를 반환한다!
        예제에서는 오류 처리 안하려고 비검사 예외 사용
         */
        String orElseThrowResult = ofNullableResult.orElseThrow(RuntimeException::new);

        /*
        Optional은 filter와 map을 바로 사용할 수 있다.
        filter는 조건에 맞는 optional을 반환하고, orElse 등으로 빈값 상황 처리할 수 있다.
        아래의 예제는 dog이라는 값이 있는지 찾고, 있다면 cat을 붙여서 반환하는 것이다. 빈값 나오면 default라고 디플트값 반환
         */
        String filterResult = ofNullableResult.filter(s -> s.equals("dog"))
                .map(s->s.concat("cat"))
                .orElse("default");

        /*
        ifPresentOrElse는 만약 값이 있다면 (k) -> void 형태의 람다를 받고, 값이 없다면 ()-> void 형태의 람다를 받는다.
         */
        ofNullableResult.ifPresentOrElse((s)-> System.out.println(s),()-> System.out.println("no"));

        /*
        or 메서드는 값이 없다면 예외를 반환하는 것이 아니라, 옵셔널을 제공해준다.
        supplier로 ()-> t 형태로 람다를 주입받은후, 반환된 optional을 대상으로 다시 연산한다.
        삼항 연산자와 느낌이 비슷하다.
         */
        String orResult = ofNullableResult.or(() -> Optional.ofNullable("hello"))
                .orElse("default");


        /*
        리스트나 배열의 경우에는 따로 Optional 지정 하지 말고, 빈값을 Collections.emptyList()로 처리하자
         */
        Collections.emptyList();



    }
}
