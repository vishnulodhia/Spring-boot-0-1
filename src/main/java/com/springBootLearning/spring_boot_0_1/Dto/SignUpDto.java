package com.springBootLearning.spring_boot_0_1.Dto;

import com.springBootLearning.spring_boot_0_1.Model.Permission;
import com.springBootLearning.spring_boot_0_1.Model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {
String email;
String password;
String name;
Set<Role> roles;
Set<Permission> permissions;
}
