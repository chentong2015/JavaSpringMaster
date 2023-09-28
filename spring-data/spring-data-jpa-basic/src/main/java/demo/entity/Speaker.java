package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "demo.entity.Speaker")
@NamedQuery(name = "Speaker.findSpeakerBySpecialLastName",  // ?1 表示提供第一个参数
        query = "select speaker from demo.entity.Speaker speaker where speaker.last_name = ?1")
@Table(name = "t_speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    // mappedBy = "speakers": refer to the Session attribute 'speakers'
    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore // 避免嵌套的循环，减少json数据结果的深度
    private List<Session> sessions;

    public Speaker() {
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
