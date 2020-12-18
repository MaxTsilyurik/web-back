package com.example.webback.business.service;

import com.example.webback.web.dto.messages.MessagesCreateDto;
import com.example.webback.web.dto.messages.MessagesReadDto;

public interface MessagesService extends DtoCrudService<Long, MessagesReadDto, MessagesCreateDto>{

}
