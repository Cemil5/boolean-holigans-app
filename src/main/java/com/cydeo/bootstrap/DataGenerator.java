package com.cydeo.bootstrap;

import com.cydeo.dto.AddressDto;
import com.cydeo.dto.RoleDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Gender;
import com.cydeo.enums.State;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {


    private final UserService userService;
    private final RoleService roleService;
//    private final AddressService addressService;

    public DataGenerator(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

    @Override
    public void run(String... args) throws Exception {

        RoleDto admin = new RoleDto(1L, "Admin");
        RoleDto manager = new RoleDto(2L, "Manager");
        RoleDto instructor = new RoleDto(3L, "Instructor");

        roleService.save(admin);
        roleService.save(manager);
        roleService.save(instructor);

        AddressDto address1 = new AddressDto("123 Main Street Anytown 12345", State.CALIFORNIA);
        AddressDto address2 = new AddressDto("456 Oak Avenue Smallville 67890", State.TEXAS);
        AddressDto address3 = new AddressDto("789 Maple Drive Suburbia 45678", State.NEW_YORK);
        AddressDto address4 = new AddressDto("321 Elm Street Springfield 23456", State.ILLINOIS);
        AddressDto address5 = new AddressDto("567 Pine Road Lakeside 78901", State.FLORIDA);
        AddressDto address6 = new AddressDto("789 Maple Drive Suburbia 45678", State.NEW_YORK);// "+1 (555) 555-9012");
        AddressDto address7 = new AddressDto("321 Elm Street Springfield 23456", State.ILLINOIS);//, "+1 (555) 555-3456");
        AddressDto address8 = new AddressDto("890 Cedar Lane Mountainview 56789", State.COLORADO);//, "+1 (555) 555-2345");
        AddressDto address9 = new AddressDto("101 Pineapple Avenue Beachtown 98765", State.HAWAII);//, "+1 (555) 555-6789");

        UserDto user1 = new UserDto("Michael", "Jordan", "mick@gmail.com", "PassWord$1", "PassWord$1","+1 (555) 555-1234", admin, Gender.MALE, address1);
        UserDto user2 = new UserDto("Larry", "Bird", "larry@gmail.com", "PassWord$2", "PassWord$2", "+1 (555) 555-5678", manager, Gender.MALE, address2);
        UserDto user3 = new UserDto("Angelina", "Sea", "star@yahoo.com", "PassWord$3", "PassWord$3", "+1 (555) 555-9012", instructor, Gender.FEMALE, address3);
        UserDto user4 = new UserDto("Elizabeth", "Loren", "loren@hotmail.com", "PassWord$4", "PassWord$4", "+1 (555) 555-2456", instructor, Gender.FEMALE, address4);
        UserDto user5 = new UserDto("Bill", "Wooden", "bill@gmail.com", "PassWord$5", "PassWord$5","+1 (555) 555-7890", instructor, Gender.MALE, address5);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

    }
}

