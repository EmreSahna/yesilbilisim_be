package org.yesilbilisim.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.dto.response.BlogResponse;
import org.yesilbilisim.backend.dto.response.BlogResponseWithPaggination;
import org.yesilbilisim.backend.dto.response.BlogsNavigatorResponse;
import org.yesilbilisim.backend.dto.response.BlogsResponse;
import org.yesilbilisim.backend.entity.Blogs.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(BlogRequest blogRequest);

    BlogResponse getBlog(String blogId);

    BlogResponseWithPaggination getBlogs(Pageable pageable);

    List<BlogsNavigatorResponse> getBlogsNavigator();
}