package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

// Entity Name设置之后则和Table Name一致
// 反之可以使用@Table(name="")来区别两个不同的名称
@Entity(name = "sessions")
// 忽略指定的属性，在序列化object对象的时候，不需要序列下面的内容
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    // 表明主键primary key在插入数据的时候会自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    @NotNull
    private String sessionName;

    @NotNull
    private String session_description;

    private Integer session_length;

    // 定义表格之间的关联, 以及汇总的表格
    @ManyToMany
    @JoinTable(name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;

    public Session() {

    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }
}
