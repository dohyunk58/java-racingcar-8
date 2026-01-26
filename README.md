# java-racingcar-precourse

우아한테크코스 8기 프리코스 2주차 괴제 내용입니다.

## 프로젝트 설명

쉼표로 구분된 자동차 이름을 입력받아 경주를 준비, 시도할 횟수를 입력받아 입력된 횟수만큼 경주를 실행한다.
각 자동차는 0-9 사이의 무작위 값을 부여받아 무작위 값이 4 이상일 경우 해당 자동차는 1칸 전진한다.
각 라운드별 실행 결과를 실시간으로 출력한다.
모든 경주가 완료된 후, 가장 멀리 이동한 자동차를 최종 우승자로 선정하여 출력한다.

## 기능 목록

1. 입력 기능
- [x] 자동차 이름을 쉼표 기준으로 입력받기
- [x] 경주 횟수 입력받기

2. 예외 처리

- [x] 자동차 이름이 5자를 초과하는 경우
- [x] 자동차 이름이 null, 빈 문자열이거나 공백만으로 이루어진 경우
- [x] 중복된 자동차 이름을 입력한 경우
- [x] 경주 횟수에 정수가 아닌 값을 입력한 경우
- [x] 경주 횟수에 자연수가 아닌 값을 입력한 경우

3. 메인 로직

- [x] 입력받은 자동차 이름을 쉼표 기준으로 나누어 자동차 객체 목록 생성
- [x] 무작위 값이 4 이상인 경우 자동차를 전진시키기
- [x] 입력된 횟수만큼 자동차 경주를 실행하기
- [x] 최종 우승자 결정하기(가장 먼 위치의 자동차를 찾아내기)

4. 출력 기능

- [x] 횟수별 자동차의 이름과 이동한 거리를 출력하기
- [x] 최종 우승자 출력하기(공동 우승 시 쉼표로 구분)

## 사용 기술

- Language: Java 21
- Build Tool: Gradle
- Test: JUnit 5, AssertJ
- Library: camp.nextstep.edu.missionutils (Console, Randoms)

## 아키텍처 및 설계 원칙

본 프로젝트는 객체 지향 설계 원칙을 준수하도록 개발되었습니다.

### 1. MVC 패턴 (Model-View-Controller)
Controller
- RacingGameController: View와 Model을 중재하며 게임의 전체 흐름(입력 ➔ 실행 ➔ 결과)을 제어

Model
- Car: name과 position을 가지며 position을 1 증가시키는 move() 메서드를 갖는다
- RacingGame: List<Car>를 관리하며 findWinners()와 같은 핵심 로직을 수행
- CarFactory: 이름 문자열을 받아 List<Car> 생성하는 Factory 객체
- Validator: 이름 및 횟수 검증 로직을 static 메서드로 제공하는 유틸리티 객체

View
- InputView: 사용자의 콘솔 입력을 담당
- OutputView: 콘솔 출력을 담당

### 2. TDD (Test-Driven Development)  
Model 계층의 모든 비즈니스 로직과 예외 상황에 대해 JUnit 5와 AssertJ를 사용하여 단위 테스트를 우선 작성하고 이를 통과하는 코드를 구현했다.

### 3. 의존성 주입 (Dependency Injection)  
Application(main)이 InputView, OutputView, CarFactory 등 필요한 객체를 생성하여 RacingGameController의 생성자로 주입한다.
- Controller가 View의 구체적인 구현이 아닌 인스턴스에 의존하게 된다.
- Controller와 View 간의 결합도가 낮아지며 Controller의 테스트가 용이하다.

### 4. 단일 책임 원칙 (SRP)

각 객체가 하나의 책임만 갖도록 분리했습니다.  
CarFactory는 '생성', Validator는 '검증', RacingGame은 '게임 로직', Controller는 '흐름 제어'의 책임을 각각 담당합니다.

## 실행 방법

1. Application.main() 메서드를 실행
2. "경주할 자동차 이름을 입력하세요..."에 따라 이름을 입력한다.(이름은 쉼표로 구분한다)
3. "시도할 횟수는 몇 회인가요?"에 따라 횟수를 입력한다.
4. 실행 결과를 확인한다.

## 프로젝트 구조

```
├── main
│   └── java
│       └── racingcar
│           ├── controller
│           │   └── RacingGameController.java   # 게임의 전체 흐름(입력 ➔ 실행 ➔ 결과)을 제어
│           ├── model
│           │   ├── Car.java                    # 자동차 name, position, move() 포함
│           │   ├── CarFactory.java             # List<Car>을 생성
│           │   ├── RacingGame.java             # findWinners()와 같은 핵심 로직을 수행
│           │   └── Validator.java              # 이름 및 횟수 검증
│           ├── view
│           │   ├── InputView.java
│           │   └── OutputView.java
│           └── Application.java
└── test
```
