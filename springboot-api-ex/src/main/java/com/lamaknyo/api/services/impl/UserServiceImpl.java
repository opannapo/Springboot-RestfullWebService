package com.lamaknyo.api.services.impl;

import com.lamaknyo.api.domain.UsersEntity;
import com.lamaknyo.api.repository.UserRepository;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repo;


    @Override
    public Optional user(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("id"), filterDto.get("id")),
                    builder.equal(root.get("status"), 1)
            );
            return query.getGroupRestriction();
        };

        return repo.findOne(spec);
    }

    @Override
    public UsersEntity auth(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("username"), filterDto.get("username")),
                    builder.equal(root.get("password"), filterDto.get("password"))

            );
            return query.getGroupRestriction();
        };

        Optional<UsersEntity> userOpt = repo.findOne(spec);
        if (!userOpt.equals(Optional.empty())) {
            UsersEntity usersEntity = userOpt.get();
            usersEntity.setLastLogedin((int) (System.currentTimeMillis() / 1000L));
            repo.save(usersEntity);
            return usersEntity;
        } else {
            return null;
        }
    }

    @Override
    public Optional updateBasic(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("id"), filterDto.get("userId")),
                    builder.equal(root.get("status"), 1)
            );
            return query.getGroupRestriction();
        };

        Optional<UsersEntity> userOpt = repo.findOne(spec);
        if (!userOpt.equals(Optional.empty())) {
            UsersEntity usersEntity = userOpt.get();
            usersEntity.setName((String) filterDto.get("name"));
            usersEntity.setPhone((String) filterDto.get("phone"));
            usersEntity.setBio((String) filterDto.get("bio"));
            usersEntity.setGender((Integer) filterDto.get("gender"));
            usersEntity.setUpdatedDate((int) (System.currentTimeMillis() / 1000L));
            repo.save(usersEntity);
            return userOpt;
        } else {
            return Optional.empty();
        }
    }
}