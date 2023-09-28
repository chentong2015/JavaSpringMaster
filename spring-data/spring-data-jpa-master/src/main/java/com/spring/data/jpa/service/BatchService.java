package com.spring.data.jpa.service;

import com.spring.data.jpa.entity.BatchEntity;
import com.spring.data.jpa.repositories.BatchConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {

    private final BatchConfigurationRepository batchRepository;

    @Autowired
    public BatchService(BatchConfigurationRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public String findLabelById(long id) {
        return batchRepository.findLabelById(id);
    }

    public List<BatchEntity> getBatchesByNameLike() {
        return batchRepository.findAll(nameLike("ab"));
    }

    // 自定义匹配的Predicate用于根据名称来模糊查询
    private Specification<BatchEntity> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
