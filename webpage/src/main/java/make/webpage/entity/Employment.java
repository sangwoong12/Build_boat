package make.webpage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Employment {
    @Id
    @GeneratedValue
    @Column(name = "Employment_id")
    private Long id;

    //직업
    private String job;
    //공고기간
    private String time;
    //근무유형
    private String workType;
    //경력
    private String career;
    //학력
    private String education;
    //기타정보
    private String etc;



}
