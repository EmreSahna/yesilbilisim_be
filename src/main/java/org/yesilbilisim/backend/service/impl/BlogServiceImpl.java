package org.yesilbilisim.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.dto.response.BlogResponse;
import org.yesilbilisim.backend.dto.response.BlogResponseWithPaggination;
import org.yesilbilisim.backend.dto.response.BlogsNavigatorResponse;
import org.yesilbilisim.backend.dto.response.BlogsResponse;
import org.yesilbilisim.backend.entity.Blogs.Blog;
import org.yesilbilisim.backend.repository.BlogRepository;
import org.yesilbilisim.backend.service.BlogService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog createBlog(BlogRequest blogRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        return blogRepository.save(Blog.builder()
                .title(blogRequest.getTitle())
                .description(blogRequest.getDescription())
                .createdDate(sdf.format(new Timestamp(System.currentTimeMillis())))
                .thumbnailImage(blogRequest.getThumbnailImage())
                .blogContent(blogRequest.getBlogContent())
                .build());
    }

    @Override
    public BlogResponse getBlog(String blogId) {
        Blog blog = blogRepository.findByBlogId(blogId);
        return BlogResponse.builder()
                .title(blog.getTitle())
                .description(blog.getDescription())
                .createdDate(blog.getCreatedDate().substring(0, (blog.getCreatedDate().length()-6)))
                .blogContent(blog.getBlogContent())
                .build();
    }

    @Override
    public BlogResponseWithPaggination getBlogs(Pageable pageable) {
        Page<Blog> blogList = blogRepository.findAllByOrderByCreatedDateDesc(pageable);
        return BlogResponseWithPaggination.builder()
                .blogResponses(blogList.get().map(blog -> {
                        return BlogsResponse.builder()
                            .thumbnailImage(blog.getThumbnailImage())
                            .createdDate(blog.getCreatedDate().substring(0,blog.getCreatedDate().length()-6))
                            .title(blog.getTitle())
                            .url(blog.getBlogId())
                            .build();
                }).collect(Collectors.toList()))
                .totalPages(blogList.getTotalPages())
                .currentPage(blogList.getNumber())
                .build();
    }

    @Override
    public List<BlogsNavigatorResponse> getBlogsNavigator() {
        return blogRepository.findTop3ByOrderByCreatedDateDesc().stream().map(blog -> {
            return BlogsNavigatorResponse.builder()
                    .thumbnailImage(blog.getThumbnailImage())
                    .createdDate(blog.getCreatedDate().substring(0,blog.getCreatedDate().length()-6))
                    .title(blog.getTitle())
                    .url(blog.getBlogId())
                    .build();
        }).collect(Collectors.toList());
    }
}
