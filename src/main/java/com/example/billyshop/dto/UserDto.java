package com.example.billyshop.dto;

import com.example.billyshop.domain.user.User;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;

    public UserDto(User user){
        BeanUtils.copyProperties(user,this);
    }

}
