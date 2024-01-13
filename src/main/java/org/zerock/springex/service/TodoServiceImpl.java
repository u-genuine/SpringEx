package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    //의존성 주입이 필요한 객체의 타입을 final로 고정하고 @RequiredArgsConstructor으로 생성자 생성.

    //데이터 베이스를 처리
    private final TodoMapper todoMapper;

    //DTO, VO 변환을 처리
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO){
        log.info(modelMapper);

        // 매개변수로 받은 DTO를 VO로 변환
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        // 변환된 VO를 todoMapper를 통해 insert 처리
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll(){
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }
}
