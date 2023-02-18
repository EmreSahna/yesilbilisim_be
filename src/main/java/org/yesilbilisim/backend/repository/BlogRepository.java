package org.yesilbilisim.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yesilbilisim.backend.entity.Blogs.Blog;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,String> {
    Blog findByBlogId(String blogId);

    List<Blog> findAllByOrderByCreatedDateDesc();

    @Query(value = "SELECT * FROM blog b order by b.created_date desc limit 3", nativeQuery = true)
    List<Blog> findTop3ByOrderByCreatedDateDesc();
}
