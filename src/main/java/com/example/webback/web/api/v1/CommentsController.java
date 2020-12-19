package com.example.webback.web.api.v1;

import com.example.webback.business.service.CommentService;
import com.example.webback.web.dto.comment.CommentCreateDto;
import com.example.webback.web.dto.comment.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.webback.utils.ApiConstant.COMMENTS;

@RequestMapping(COMMENTS)
@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final CommentService service;


    @GetMapping
    public List<CommentDto> getAll(){
        return service.findAllDto();
    }

    @PostMapping
    public Long save(@RequestBody CommentCreateDto dto){
        return service.saveDto(dto);
    }

    @PutMapping
    public void update(@RequestBody CommentCreateDto dto) { service.update(dto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){service.delete(id);}
}
