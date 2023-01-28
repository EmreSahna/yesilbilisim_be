package org.yesilbilisim.website.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.dto.request.BrandRequest;
import org.yesilbilisim.website.dto.request.ProductRequest;
import org.yesilbilisim.website.dto.response.ProductPageResponse;
import org.yesilbilisim.website.dto.response.ProductResponse;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.model.Products.Brand;
import org.yesilbilisim.website.model.Products.Product;
import org.yesilbilisim.website.model.Products.ProductImage;
import org.yesilbilisim.website.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }

    @PostMapping("/create-brand")
    public ResponseEntity<Brand> createBrand(@RequestBody BrandRequest brandRequest) {
        return new ResponseEntity<>(productService.createBrand(brandRequest), HttpStatus.CREATED);
    }

    @PostMapping("/create-product-image")
    public ResponseEntity<ImageModel> saveImage(@RequestParam("file") MultipartFile photo,
                                                @RequestParam("folder") String folder,
                                                @RequestParam("product_id") Long productId) {
        return new ResponseEntity<>(productService.createProductImage(folder, photo,productId), HttpStatus.CREATED);
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<ProductPageResponse>> getPage(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(productService.getPage(page, size), HttpStatus.OK);
    }
}
