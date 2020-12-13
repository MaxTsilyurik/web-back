package com.example.webback.web.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.webback.business.utils.ApiConstant.FRIENDS;

@RequestMapping(FRIENDS)
@RestController
public class FriendsController {
}