# 프레임워크 구현
## 진행 방법
* 프레임워크 구현에 대한 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


----
# Step 1 자바 reflection
- [x] 클래스 정보 출력 : Question 클래스의 모든 필드, 생성자, 메소드에 대한 정보 출력
- [x] test로 시작하는 메소드 실행 : Junit3Runner 클래스 중 test로 시작하는 메소드 실행
- [x] @Test 애노테이션 메소드 실행 : Junit4TestRunner 클래스 중 @MyTest 어노테이션 메소드 실행
- [x] private field에 값 할당 : Student의 필드 값을 주입
- [x] 인자를 가진 생성자의 인스턴스 생성 : Question 인스턴스 생성
- [x] component scan :  @Controller, @Service, @Repository 애노테이션이 설정되어 있는 모든 클래스 출력

# Step 2 
* 요구사항 1 - 애노테이션 기반 MVC 프레임워크
- [ ] @RequestMapping : controller -> method mapping 으로 변경
- [ ] @RequestMapping : HTTP 메소드 매핑 추가

- [ ] 어노테이션 기반 컨트롤러 작성 : AnnotationHandlerMappingTest 파일에 Test 패스

* 요구사항 2 - 레거시 MVC와 애노테이션 기반 MVC 통합
- [ ] 기존 코드와 공존하게 점진적 리팩토링 