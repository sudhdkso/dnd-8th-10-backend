package dnd.dnd10_backend.board.domain;

import com.sun.istack.NotNull;
import dnd.dnd10_backend.common.domain.BaseTimeEntity;
import dnd.dnd10_backend.user.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotNull
    private String content;

    /*작성자 정보*/
    private Long userCode;

    private String userName;

    private Role role;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public void update(String content) {
        this.content = content;
    }
}
