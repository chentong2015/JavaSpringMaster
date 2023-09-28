package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.BatchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchConfigurationRepository extends CrudRepository<BatchEntity, Long>,
        PagingAndSortingRepository<BatchEntity, Long>, // 用来执行分页查询和排序操作
        JpaSpecificationExecutor<BatchEntity> { // 用来执行"非与或"及特殊判断

    BatchEntity findByName(String name);

    @Query(value = "SELECT m_label FROM t_batch_entity WHERE id = :id", nativeQuery = true)
    String findLabelById(@Param(value = "id") long id);

    List<BatchEntity> findAll();

    // 分页查询时在Service层面提供Pageable的实现，定义分页大小及排序
    // @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable
    Page<BatchEntity> findAll(Pageable pageRequest);

    // 提供特殊的匹配判断条件Specification来进行查询
    List<BatchEntity> findAll(Specification<BatchEntity> spec);

    // Page<BatchEntity> findByIdIn(List<Long> ids, Pageable pageRequest);

    // BatchEntity findByLabelAndType(String label, String batchType);

    // BatchEntity findByIdAndType(Long id, String batchType);

    // Page<BatchEntity> findByType(String batchType, Pageable pageRequest);

    // List<BatchEntity> findByType(String batchType);

    // List<BatchEntity> findAllByTypeIn(List<String> batchTypes);

    // List<BatchEntity> findAllByScannerTemplateRef(Long scannerRef);

    // List<BatchEntity> findAllByGlobalFilter(String globalFilter);

    // List<BatchEntity> findAllByTypeAndLabelOfData(String batchType, String labelOfData);
}