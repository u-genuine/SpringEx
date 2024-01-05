package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor //필요한 생성자 함수를 자동으로 작성
public class SampleService {

    //기존 코드
    //@Autowired
    //private SampleDAO sampleDAO;

    //생성자 주입 방식
    //주입 받아야 하는 객체의 변수는 final
    //생성자를 이용해 해당 변수를 생성자의 파라미터로 지정
    private final SampleDAO sampleDAO;

}
