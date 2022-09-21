package demo.repositories;

import demo.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

// <Session, Long> 指定数据类型和Table的主键
// JpaRepository<Session, Long> 接口中包含基本的数据库执行的操作
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    // 根据调用是传递的参数，生成HQL查询语句，最终执行指定的SQL
    // 如果定义的HQL语句是正确的，则编译上不会由任何错误的提升 !!
    @Query("select s from sessions s where ((s.sessionName = :name and s.session_description like :description%) and s.session_length >= :length)")
    List<Session> getSessionsByFilters(@Param("name") String name,
                                       @Param("description") String description,
                                       @Param("length") int length);

    // 推荐直接使用Native Query来调用CAST()方法
    @Query(value = "select s from sessions s where (CAST(:startTime as date) is null)", nativeQuery = true)
    List<Session> getSessionByDates(@Nullable @Param("startTime") ZonedDateTime startTime);

}
