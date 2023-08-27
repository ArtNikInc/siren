package main.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "subTitle")
    private String subTitle;

    @Column(name = "body")
    private String body;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "published_at")
    private Date publishedAt;
}
