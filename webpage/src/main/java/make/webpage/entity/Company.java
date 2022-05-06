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
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "Company_id")
    private Long id;
    //회사이름
    private String companyName;
    //사업자등록번호
    private Integer companyRegistrationNumber;
    //회사위치
    private String companyLocation;
    //회사사이트
    private String companySite;




}
