## Singleton Pattern
싱글턴 패턴은 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다.  


### Lazy instantiation 게으른 인스턴스 생성

```java
class Singleton {
      // 유일한 인스턴스 저장하기 위한 정적 변수
      private static Singleton uniqueInstance;

      // 기타 인스턴스 추가 가능...

      // private 생성자 - 클래스 내부에서만 인스턴스를 생성할 수 있다.
      private Singleton() {}

      // 유일한 인스턴스를 만들어서 반환하는 정적 메소드
      public static Singleton getInstance() {
            if (uniqueInstance == null) {
                  uniqueInstance = new Singleton();
            }

            return uniqueInstance;
      }

      // 기타 메소드 추가가능...
	
}
```
- 문제점 : 다중 스레드를 사용할 때, 여러 인스턴스가 생성될 수 있다.

|1번 스레드|2번스레드|uniqueInstance값|
|---------|---------|----------------|
|`public static Singleton getInstance()`| |null, 생성 전|
| |`public static Singleton getInstance()`|null, 생성 전|
|`if (uniqueInstance == null)`| |null, 생성 전이기 때문에 <br> if문 안 실행구문으로 들어간다.|
| |`if (uniqueInstance == null)`|null, 생성 전이기 때문에 <br> if문 안 실행구문으로 들어간다.|
|`uniqueInstance = new Singleton();` <br> `return uniqueInstance;`| |object1, 인스턴스가 생성된다.|
| |`uniqueInstance = new Singleton();` <br> `return uniqueInstance;`|object2, 또 다른 인스턴스가 생성된다.|


<br><hr>

### getInstance() 메소드를 동기화하는 방법
- synchronized : 멀티스레드 환경에서 스레드 간에 서로 공유하고 수정할 수 있는 data들을 동기화 해준다. => thread-safe
- 메소드를 동기화하면 성능이 100배 저하되기 때문에 속도가 중요하지 않는 경우에만 사용하도록 한다.

```java
class Singleton {
      private static Singleton uniqueInstance;

      private Singleton() {}

      public static synchronized Singleton getInstance() {  // 메소드 동기화
            if (uniqueInstance == null) {
                  uniqueInstance = new Singleton();
            }

            return uniqueInstance;
      }

	
}
```


<br><hr>

### 인스턴스를 시작하자마자 만드는 방법
- 정적 초기화 부분에서 인스턴스 바로 생성하면 멀티 스레드에도 문제 없다.

```java
class Singleton {
      private static Singleton uniqueInstance = new Singleton();  // 인스턴스 바로 생성

      private Singleton() {}

      public static Singleton getInstance() {
            return uniqueInstance; // 바로 리턴
      }
	
}
```

<br><hr>

### DCL(Double-Checking Locking)을 쓰는 방법
- 먼저 인스턴스가 생성되어 있는지 확인한 후, 생성되어 있지 않았을 때만 동기화한다.
- volatile 키워드 : 자바 5 이전 버전에서는 사용 불가.
- 처음에만 동기화되므로, 속도 문제를 줄일 수 있다.

```java
class Singleton {
      private volatile static Singleton uniqueInstance;

      private Singleton() {}

      public static Singleton getInstance() {
            if (uniqueInstance == null) {  // 인스턴스가 없으면(처음이면) 동기화 1번만
                  synchronized (Singleton.class) {
                        if (uniqueInstance == null) {  // 
                              uniqueInstance = new Singleton();
                        }
                  }
            }
            return uniqueInstance;
      }
	
}
```


