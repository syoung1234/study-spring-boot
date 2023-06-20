package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 1. 인터페이스 InitializingBean, DisposableBean => 거의 사용하지 않음
 * 2. 빈 등록 초기화, 소멸 메서드
 * 3. 애노테이션 @PostConstruct, @PreDestroy => 사용하기
 */
public class NetworkClient {
//public class NetworkClient implements InitializingBean, DisposableBean {


    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    /**
     * 1. 인터페이스 InitializingBean, DisposableBean => 거의 사용하지 않음
     */
    // 의존 관계 주입이 끝나면 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

    // 빈이 종료 될 때
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    /**
     * 2. 빈 등록 초기화, 소멸 메서드
     */
    @PostConstruct // 3. 애노테이션 @PostConstruct, @PreDestroy => 사용하기
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy // 3. 애노테이션 @PostConstruct, @PreDestroy => 사용하기
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
