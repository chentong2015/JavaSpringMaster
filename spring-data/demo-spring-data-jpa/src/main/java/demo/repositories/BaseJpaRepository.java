package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// 标注泛型化的JpaRepository<T>不需要生成Bean，注入到Spring IoC中
@NoRepositoryBean
public interface BaseJpaRepository<T> extends JpaRepository<T, Long> {
}
