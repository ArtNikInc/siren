package main.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;
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

    private String text;

    private String subTitle;

}
