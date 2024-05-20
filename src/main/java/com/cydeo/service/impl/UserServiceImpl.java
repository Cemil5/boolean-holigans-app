package com.cydeo.service.impl;

import com.cydeo.dto.UserDto;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<UserDto,String> implements UserService {


    @Override
    public UserDto save(UserDto object) {
        return super.save(object.getUserName(),object);
    }

    @Override
    public UserDto findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return super.findAll();
    }

    @Override
    public void update(UserDto object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);

    }
}
