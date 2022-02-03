package repositories;

import model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

// <Session, Long> 指定数据类型和Table的主键
public interface SessionRepository extends JpaRepository<Session, Long> {
}
