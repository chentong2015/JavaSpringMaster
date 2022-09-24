package demo.repositories;

import demo.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    // 该方法可以直接写到@Entity上，补充@Query语句
    Speaker findSpeakerBySpecialLastName(String lastName);

    // 自定义执行的方法: 抽象执行的逻辑，传递"具名参数"
    @Query("select speaker from speakers speaker where speaker.first_name = :firstName or speaker.last_name = :lastName")
    Speaker findBySpecialFirstNameAndLastName(@Param("lastName") String firstName, @Param("firstName") String lastName);
}
