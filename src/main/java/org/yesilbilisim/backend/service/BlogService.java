package org.yesilbilisim.backend.service;

import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.dto.response.BlogsNavigatorResponse;
import org.yesilbilisim.backend.dto.response.BlogsResponse;
import org.yesilbilisim.backend.entity.Blogs.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(BlogRequest blogRequest);

    Blog getBlog(String blogId);

    List<BlogsResponse> getBlogs();

    List<BlogsNavigatorResponse> getBlogsNavigator();
}