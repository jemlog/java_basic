## 기본 클래스 
<hr>

- 클래스와 인터페이스는 컴파일될때 .java 파일에서 .class 파일로 변환된다.
- class 파일에는 class의 이름, 메서드명, 필드명 등 여러 메타정보가 포함된다.
- class 정보를 얻어내서 새로운 인스턴스를 만들거나, 메서드를 호출하는 작업을 **리플랙션**이라고 한다. 

### Class의 기본 메서드
<hr>

Class.forName("java.lang.String") -> 이름으로 클래스 메타정보를 불러온다.
<br>
class.getMethod() -> 클래스의 메서드 정보를 가져온다. 
<br>
class.getName() -> 클래스의 이름을 가져온다. 
<br>
method.invoke()