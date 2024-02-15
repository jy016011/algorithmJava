# Java Src Files of algorithm problems solved

## java 적응기 Note

### 23.09.17

FoldingPaper구현을 파이썬과 자바 두 코드로 각각 작성하였는데,

함수의 파라미터로 메인함수에서의 배열을 넣었을 경우 파이썬은 함수 내부에서 배열 값을 바꾸더라도
메인함수에 있던 파라미터로 넣었던 배열의 값은 안바뀌었음.

반면에, 자바의 경우 함수 내부에서 배열 값을 바꾸면, 메인함수에서도 파라미터로 넣었던 배열 값이 바뀌었다.

앞으로 이런부분에 주의하며 코딩해야할듯.

---

### 23.10.16

백준 2346문제 풀이간 Deque를 LinkedList로 구현시 메모리 초과 발생하는 문제가 있었음.

이는 ArrayDeque를 이용하여 해결.

Deque이용시 ArrayDeque, LinkedList 어느걸 써야할까?

ArrayDeque는 Deque의 구현체: 배열의 특성을 가짐, LinkedList는 List의 구현체: List의 특성을 가짐.

배열의 경우 고정된 크기가 주어지기 때문에 검색이 빠르지만, 중간 삽입/삭제시 배열 크기 재조정때문에 추가 비용 및 연산이 발생하고, 공간 비효율성과 배열의 재배치가 일어날 수 있다.

그러나 Deque의 경우 '양끝'에서만 삭제가 일어나므로 시간복잡도는 O(1)이 된다.

따라서 리스트와 별차이가 없음.

또한, ArrayDeque의 경우 Random Access가 가능하기에 원소 조회 시 속도가 빠름.

LinkedList는 특정 원소 접근 시의 성능은 ArrayDeque에 비해 떨어짐(O(n)).

또한, ArrayDeque는 Array에 의해 지원되므로 LinkedList에 비해 cache-locality에 친숙하여 연산속도가 더 빠름.

메모리 측면에서도 ArrayDeque는 LinkedList와 달리 다음 노드를 참조하지 않기 때문에 더 적은 메모리 사용.

But, Thread-safe하지 않으므로 Multi Thread환경에서는 문제가 있다. 멀티 때는 synchronized를 이용하여 구현.

-> ArrayDeque 써야겠다.

---

### 23.10.17

Arrays.sort와 Collections.sort의 차이?

Arrays.sort: 베열을 대상, 기본형 배열의 경우 Dual Pivot Quick sort, 참조형(String[], Object[] 등)의 경우 Tim sort

Collections.sort: Tim sort 알고리즘, 리스트와 같은 객체 대상

DualPivotQuickSort vs TimSort ?

DualPivotQuickSort의 시간 복잡도는 평균 O(nlogn), 최악 O(n^2)

TimSort의 시간 복잡도는 평균과 최악 모두 O(nlogn).

그러나, 실제로는 평균 속도가 DualPivotQuickSort가 더 빠르고, 메모리도 MergerSort(임시로 추가 메모리 공간을 만듬.)를 합쳐 만든 TimSort보다 덜 먹는다고 한다.

또한, 기본형 배열의 경우 메모리에 연속적으로 저장하기때문에 참조 지역성이 좋아 DualPivotQucikSort의 성능이 극대화 되는 모양이다.

(QuickSort의 참조지역성이 O(nlogn) 알고리즘 중에 제일 좋다고 한다.)

-> 배열의 경우 Arrays.sort 먼저 써보고, 시간 초과뜨면 Collections.sort 쓰고, 객체는 그냥 Collections.sort 쓰자

---

### 23.10.18

split()을 이용하여 Strings 배열 만들었는데, regex를 "+"로 두면 dangling quantifier '+' 라며 오류 발생.

'+'는 특별한 의미를 갖는 메타 문자이라서 오류내는 것임

-> split("\\+")로 쓰자

---

이후 풀이하면서 인상 깊었던 문제들은 Velog에서 다루겠음.

---

## Java LTS(Long Term Support) 버전들

### 1. Java 8 (~ 2030.12)

- 오라클이 자바 인수 후 출시한 첫 번째 LTS 버전
- 32비트를 지원하는 마지막 공식 Java 버전
- Oracle(유료), Opne(무료) JDK로 나뉨
- `LocalDateTime`등의 새로운 날짜와 시간 API
- 람다식
- Stream API
- Unsigned Integer 계산
- 인터페이스 Default 메소드(인터페이스 내 구현 가능한 메소드)
- Optional class(null이 올 수 있는 값을 감싸는 Wrapper 클래스) 등

### 2. Java 11 (~ 2026.09)

- Oracle 및 Open JDK 통합, Oracle은 구독형 유료로 전환
- 람다 지역 변수 `var` 키워드(데이터 유형 지정 없이 변수 선언 및 정의) 사용가능
- HTTP Client API : HTTP/1.1, HTTP/2 지원 등

### 3. Java 17 (~ 2029.09)

- `Spring Boot 3.0`의 최소 요구 Java 버전
- Sealed Class / Interface (싱속 혹은 구현할 클래스를 지정함) 정식 추가
- Record Data Class(불변 데이터를 객체 간 전달) 정식 추가
- Apple 실리콘 프로세서 정식 지원
- 의사 난수 생성기를 통해 예측하기 어려운 난수 생성 API 추가 등

### 4. 현재 사용 중인 버전들

- SpringBoot 프로젝트: Java 17
- 알고리즘 풀이: Java 11(BOJ 지원버전)

