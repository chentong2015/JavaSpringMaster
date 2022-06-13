package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

// Entity实体映射到数据库中的Table表格，确定使用的table名称
@Entity(name = "sessions")
// 忽略指定的属性，在序列化object对象的时候，不需要序列下面的内容
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    // 字段的名称需要和表的列的名称严格的一致
    // 表明主键，这个primary key在插入数据的时候会自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    // TODO: 下面的名称在数据库中会自动的映射到指定的列名称中
    //      table中的名称是lower case, 会转换映射到"session_name"列名称上 !!
    // @Column(name = "component_id", nullable = false) 或者使用列的对应标注
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
