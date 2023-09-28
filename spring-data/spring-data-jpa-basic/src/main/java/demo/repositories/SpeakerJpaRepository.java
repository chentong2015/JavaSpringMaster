package demo.repositories;

import demo.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {

    // 该方法可以直接写到@Entity上，补充@Query语句
    Speaker findSpeakerBySpecialLastName(String lastName);

    // 自定义执行的方法: 抽象执行的逻辑，传递"具名参数"
    @Query("select speaker from demo.entity.Speaker speaker where speaker.first_name = :firstName or speaker.last_name = :lastName")
    Speaker findBySpecialFirstNameAndLastName(@Param("lastName") String firstName, @Param("firstName") String lastName);

    // TODO. 声明使用Native Query查询方式, 否则会按照JPQL specification标准
    @Query(value = "SELECT * from t_speackers", nativeQuery = true)
    List<Speaker> getListSpeakers();

    // Native Query查询中支持使用系统function来操作，比如CAST( to )针对时间的处理
    // @Query("... where cast(:startTime as data) is null")
    // List<Object> findAllObjects(@Nullable @Param("startTime") ZonedDateTime startTime);
}
