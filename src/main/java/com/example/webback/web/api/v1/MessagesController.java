package com.example.webback.web.api.v1;

import com.example.webback.business.service.MessagesService;
import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.webback.utils.ApiConstant.MESSAGES;

@RestController
@RequestMapping(MESSAGES)
public class MessagesController {

    private final MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    public List<MessagesReadDto> getAll(){
        return messagesService.findAllDto();
    }

    @PostMapping
    public Long save(@RequestBody MessagesCreateDto dto){
        return messagesService.saveDto(dto);
    }

    @PutMapping
    public void update(@RequestBody MessagesCreateDto dto) { messagesService.update(dto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){messagesService.delete(id);}

}
