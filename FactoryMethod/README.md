## Factory Method

#### 객체의 인스턴스를 만드는 작업을 공개하지 않는다. 
  => 불필요한 의존성 제거

#### new
인스턴스를 만드는 것, 인터페이스가 아닌 특정 구현을 사용하는 것   
=> 유연성이 떨어지고, 나중에 코드 변경 가능성이 높아짐, 변화에 대해 닫혀있다. (OCP위반)  
```
Duck duck = new MallardDuck();   // MallardDuck 은 구상 클래스
```


#### 바뀔수 있는 부분, 바꾸지 않는 부분을 분리하라!!
```
바뀌는 부분 : 피자 종류에 따라 피자 생성 부분이 바뀜  
바뀌지 않는 부분 : 피자 준비, 굽기, 자르기, 포장 부분
```

#### 바뀌는 부분 => 캡슐화
```
SimplePizzaFactory : 피자 종류에 따라 생성하는 클래스  
=> 나중에 여러 곳에서 사용할 수 있다.  (ex. 피자 종류에 따라 다른 메뉴, 설명...)    
=> 수정할 때, 여기저기 들어가 고칠 필요 없이 이 클래스만 고치면 됨  
```

#### 간단한 팩도리 Simple Factory
PizzaStore  <-  SimplePizzaFactory  <-  Pizza

#### 생산자(Creator) 클래스
부모 : PizzaStore  
  - createPizza() : 추상메소드, 피자 인스턴스 생성한다
  - orderPizza() : 피자 생성과 완전히 분리, 어떤 피자인지 모르는 상태로 피자를 준비, 굽기, 자르기, 포장하는 일을 한다.
자식 : NYPizzaStore / ChicagoPizzaStore
  - createPizza() : 부모의 추상메소드를 구현, 피자 종류에 따라 피자를 생성한다.

#### 제품(Product) 클래스
부모 : Pizza
자식 : NYStyleCheesePizza, NYStyleVeggiePizza... / ChicagoStyleCheesePizza, ChicagoStyleVeggiePizza...



#### 팩토리 메소드
부모 추상 클래스에 존재 (ex. createPizza())  
객체 생성을 처리하는 메소드, 객체 생성 작업은 서브클래스에게 넘긴다. (캡슐화)
```
abstract Product factoryMethod(String type);

abstract Pizza createPizza(String type);
```

#### 팩토리 메소드 패턴




