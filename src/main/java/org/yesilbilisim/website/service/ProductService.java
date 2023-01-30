package org.yesilbilisim.website.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.dto.request.BrandRequest;
import org.yesilbilisim.website.dto.request.CategoryRequest;
import org.yesilbilisim.website.dto.request.ProductRequest;
import org.yesilbilisim.website.dto.response.*;
import org.yesilbilisim.website.model.Products.Brand;
import org.yesilbilisim.website.model.Products.Category;
import org.yesilbilisim.website.model.Products.Product;
import org.yesilbilisim.website.model.Products.ProductImage;
import org.yesilbilisim.website.repository.BrandRepository;
import org.yesilbilisim.website.repository.CategoryRepository;
import org.yesilbilisim.website.repository.ProductImageRepository;
import org.yesilbilisim.website.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ProductImageRepository productImageRepository;
    private final ImageService imageService;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository, ProductImageRepository productImageRepository, ImageService imageService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.productImageRepository = productImageRepository;
        this.imageService = imageService;
        this.categoryRepository = categoryRepository;
    }

    public ProductImage createProductImage(String folder, MultipartFile photo, Long productId) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        imageService.saveImage(photo, folder, fileName);

        return productImageRepository.save(ProductImage.builder()
                .filename(fileName)
                .folder(folder)
                .product(productRepository.findById(productId).orElse(null))
                .build());
    }

    public Brand createBrand(BrandRequest brandRequest) {
        return brandRepository.save(Brand.builder()
                .name(brandRequest.getName())
                .build());
    }

    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.save(Category.builder()
                .name(categoryRequest.getName())
                .build());
    }

    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .brand(brandRepository.findById(productRequest.getBrandId()).orElse(null))
                .category(categoryRepository.findById(productRequest.getCategoryId()).orElse(null))
                .build());
    }

    public BrandResponse getBrand(Long id) {
        return brandRepository.findById(id).map(brand -> BrandResponse.builder()
                .name(brand.getName())
                .build()).orElse(null);
    }

    public CategoryResponse getCategory(Long id) {
        return categoryRepository.findById(id).map(category -> CategoryResponse.builder()
                .name(category.getName())
                .build()).orElse(null);
    }

    public List<ProductImageResponse> getProductImages(Long id) {
        return productImageRepository.findAllByProductId(id).stream().map(productImage -> ProductImageResponse.builder()
                .folder(productImage.getFolder())
                .filename(productImage.getFilename())
                .build()).toList();
    }

    public ProductResponse getProduct(Long id) {
        return productRepository.findById(id).map(product -> ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .brand(getBrand(product.getBrand().getId()))
                .category(getCategory(product.getCategory().getId()))
                .images(getProductImages(product.getId()))
                .build()).orElse(null);
    }

    public ProductPageResponse getPage(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Product> pagedResult = productRepository.findAll(paging);

        return ProductPageResponse.builder()
                .products(pagedResult.getContent().stream().map(product -> ProductCardResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .brand(getBrand(product.getBrand().getId()))
                        .image(getProductImages(product.getId()).get(0))
                        .build()).toList())
                .currentPage(pagedResult.getNumber())
                .totalElements((int) pagedResult.getTotalElements())
                .totalPages(pagedResult.getTotalPages())
                .build();
    }

    public ProductPageFilterResponse getPageFilter(){
        return ProductPageFilterResponse.builder()
                .brands(brandRepository.findAll().stream().map(brand -> BrandResponse.builder()
                        .name(brand.getName())
                        .build()).toList())
                .categories(categoryRepository.findAll().stream().map(category -> CategoryResponse.builder()
                        .name(category.getName())
                        .build()).toList())
                .maxPrice(productRepository.findMaxPrice())
                .build();
    }
}