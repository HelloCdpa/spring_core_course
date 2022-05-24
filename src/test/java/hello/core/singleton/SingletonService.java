package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 외부에 private 으로 static 으로 가지고 있음 -> static 영역에 하나만 만들어서 올라감
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
