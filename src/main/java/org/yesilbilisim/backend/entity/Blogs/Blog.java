package org.yesilbilisim.backend.entity.Blogs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@Table(name = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(generator = "route-id")
    @GenericGenerator(name = "route-id", strategy = "org.yesilbilisim.backend.util.RouteIdGenerator")
    private String blogId;
    private String title;
    private String description;
    private String createdDate;
    @Column(length = 10000)
    private String blogContent;
    private String tags;
    private String thumbnailImage;
}
