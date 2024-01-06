package org.zerock.springex.sample;

//인터페이스를 이용해서 SampleService는 SampleDAO의 실체를 모르기 때문에 SampleDAOImpl 수정할 때 유연해짐

//SampleService 입장에서는 인터페이스만 바라보고 있기 때문에 실제 객체가 SampleDAOImpl의 인스턴스인지 알 수 없음
//객체와 객체의 의존관계의 실제 객체를 몰라도 가능하게 하는 방식 -> 느슨한 결합 (loose coupling)
public interface SampleDAO {
}
