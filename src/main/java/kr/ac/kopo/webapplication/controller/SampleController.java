package kr.ac.kopo.webapplication.controller;


import kr.ac.kopo.webapplication.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller //웹페이지 실행
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/ex1")
    public void ex(){

    }

    @GetMapping({"/ex2","/ex2_1"})
    public void exModel(Model model) {
        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i ->{
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First..."+i)
                    .last("last..."+i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list",list);
    }
}