package dnd.dnd10_backend.board.dto.request;

import dnd.dnd10_backend.board.domain.Post;
import dnd.dnd10_backend.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostCreateDto {

    private String title;

    private String content;

    private String category;

    //이미지 추가해야함

    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .content(content)
                .category(category)
                .userCode(user.getUserCode())
                .userName(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
