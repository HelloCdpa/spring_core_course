ApplicationContext = 스프링 컨테이너
@Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨데이너에 등록한다.   
이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라한다.  
이전 : AppConfig 로 직접 조회 -> 현재 : 스프링컨테이너로 필요한 빈을 찾음 applicationContext.getBean()  
자바코드로 조회 -> @Bean 으로 등록해서 스프링 컨테이너에서 빈을 찾아 사용