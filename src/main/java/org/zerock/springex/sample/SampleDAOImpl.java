package org.zerock.springex.sample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//SampleService 입장에서는 인터페이스만 바라보고 있기 때문에 실제 객체가 SampleDAOImpl의 인스턴스인지 알 수 없음
//객체와 객체의 의존관계의 실제 객체를 몰라도 가능하게 하는 방식 -> 느슨한 결합 (loose coupling)
@Repository
//@Qualifier("normal")
@Primary
public class SampleDAOImpl implements SampleDAO{
}
