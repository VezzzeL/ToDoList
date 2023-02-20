package com.softserve.itacademy.service.impl;

import com.softserve.itacademy.exceptions.EntityNotFoundException;
import com.softserve.itacademy.exceptions.NullEntityReferenceException;
import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.repository.RoleRepository;
import com.softserve.itacademy.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        if (role == null) {
            throw new NullEntityReferenceException("Role cannot be 'null'");
        } else {
            return roleRepository.save(role);
        }
    }

    @Override
    public Role readById(long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Role update(Role role) {
        if (role != null) {
            Role oldRole = readById(role.getId());
            if (oldRole != null) {
                return roleRepository.save(role);
            }
        }
        throw new NullEntityReferenceException("Role cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        Role role = readById(id);
        if (role != null) {
            roleRepository.delete(role);
        } else {
            throw new NullEntityReferenceException("Role cannot be 'null'");
        }
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.isEmpty() ? new ArrayList<>() : roles;
    }
}
