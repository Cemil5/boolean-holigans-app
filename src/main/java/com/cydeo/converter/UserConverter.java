package com.cydeo.converter;
import com.cydeo.dto.UserDto;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserConverter implements Converter<String, UserDto> {
    UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }

        return userService.findById(source);
    }
}

