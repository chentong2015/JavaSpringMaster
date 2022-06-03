package demo.query;

import demo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// You have tell Spring to treat that query as native one.
// Otherwise it will try to validate it according to the JPA specification.
public interface SpringJpaNativeQuery extends JpaRepository<Speaker, Long> {

    // For Spring Data 2.0.5 and above 在这之上的版本，最好使用nativeQuery的查询方式 !!
    // @Query(<Entity.FunctionName>, nativeQuery=true)
    @Query(value = "SELECT ...", nativeQuery = true)
    List<Object[]> transactions();
}
