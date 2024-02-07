package org.example.caching.service;

import org.example.caching.bean.Employee;
import org.example.caching.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    // Cacheable标注在方法上，注明要返回的数据是被缓存的
    // 根据key判断缓存是否存在，如果不存在才会指定方法逻辑
    @Cacheable(value = "employees", key = "#id", condition="#id > 0")
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    // CachePut无论缓存是否存在，都会写入到缓存中
    @CachePut(cacheNames = "employees", key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    // CacheEvict移除掉之前缓存的数据，根据缓存名称判断
    @Caching(evict = {
            @CacheEvict(cacheNames = "departments", allEntries = true),
            @CacheEvict(cacheNames = "employees", key = "...")})
    public boolean importEmployees(List<Employee> employeeList) {
        for (Employee employee: employeeList) {
            saveEmployee(employee);
        }
        return true;
    }
}
