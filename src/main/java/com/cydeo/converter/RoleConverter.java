package com.cydeo.converter;

import com.cydeo.dto.RoleDto;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleConverter implements Converter<String, RoleDto> {

    final RoleService roleService;

    public RoleConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        return roleService.findById(Long.parseLong(source));
    }
}
