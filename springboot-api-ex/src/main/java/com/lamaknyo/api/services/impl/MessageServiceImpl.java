package com.lamaknyo.api.services.impl;

import com.lamaknyo.api.domain.MessagesEntity;
import com.lamaknyo.api.domain.UsersEntity;
import com.lamaknyo.api.repository.MessageRepository;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository repo;

    @Override
    public Optional message(FilterDto filterDto) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("id"), filterDto.get("id")),
                    builder.equal(root.get("status"), 1)
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        return repo.findOne(spec);
    }

    @Override
    public Page messageOfUser(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("usrId"), filterDto.get("userId"))
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        Page<MessagesEntity> messages = repo.findAll(spec, PageRequest.of(page - 1, limit));
        messages.forEach(messagesEntity -> {
                    //messagesEntity.setUser(null);
                    UsersEntity user = messagesEntity.getUser();
                    user.setAddress(null);
                }
        );


        return messages;
    }

    @Override
    public Page messageOfMe(FilterDto filterDto, int page, int limit) {
        Specification spec = (Specification) (root, query, builder) -> {
            query.where(
                    builder.equal(root.get("status"), 1),
                    builder.equal(root.get("usrId"), filterDto.get("userId"))
            ).orderBy(builder.asc(root.get("id"))).distinct(true);
            return query.getGroupRestriction();
        };

        Page<MessagesEntity> messages = repo.findAll(spec, PageRequest.of(page - 1, limit));
        messages.forEach(messagesEntity -> messagesEntity.setUser(null));

        return messages;
    }
}
