package dnd.dnd10_backend.checkList.domain;

import dnd.dnd10_backend.checkList.dto.request.CheckListRequestDto;
import dnd.dnd10_backend.checkList.dto.request.UpdateCheckListRequestDto;
import dnd.dnd10_backend.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 패키지명 dnd.dnd10_backend.checkList.domain
 * 클래스명 CheckList
 * 클래스설명
 * 작성일 2023-02-05
 *
 * @author 원지윤
 * @version 1.0
 * [수정내용]
 * 예시) [2022-09-17] 주석추가 - 원지윤
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "check_list")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_idx")
    private Long checkIdx;

    @Column(name = "check_date")
    private LocalDate date;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time",nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createTime;

    @Column(name = "modified_time",nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_code")
    private User user;

    @Builder
    public CheckList(LocalDate date, String content, String status, User user) {
        this.date = date;
        this.content = content;
        this.status = status;
        this.user = user;
        this.modifiedTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public CheckList(CheckListRequestDto requestDto, User user) {
        this.date = requestDto.getDate();
        this.content = requestDto.getContent();
        this.status = requestDto.getStatus();
        this.user = user;
        this.modifiedTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public void update(UpdateCheckListRequestDto requestDto){
        this.content = requestDto.getContent();
        this.status = requestDto.getStatus();
    }
}
