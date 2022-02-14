package classReflection;

import java.lang.reflect.Method;

public class ClassStudy {

    public static void main(String[] args) throws Throwable{

        Person person = new Person();

        // 클래스 이름으로 클래스 정보 조회
        Class<?> c = Class.forName("classReflection.Person");

        // 메서드 이름으로 메서드 조회
        Method getName = c.getMethod("getName");

        // method.invoke(실제 인스턴스)를 통해 인스턴스의 getName 메서드 호출
        Object invokePerson = getName.invoke(person);

        // 리플렉션 기술을 통해 새로운 Person형 인스턴스 생성
        Object newPersonByReflection = c.newInstance();

    }
}
