package main.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PostDto {

    @Nullable
    private UUID id;

    private String title;

    private String body;

    private String subTitle;

}
