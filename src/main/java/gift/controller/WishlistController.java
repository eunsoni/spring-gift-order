package gift.controller;


import gift.service.MemberService;
import gift.service.ProductService;
import gift.service.WishlistService;
import gift.util.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    private final MemberService memberService;
    private final ProductService productService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public WishlistController(WishlistService wishlistService, ProductService productService, MemberService memberService, JwtTokenProvider jwtTokenProvider) {
        this.wishlistService = wishlistService;
        this.productService = productService;
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteWishlistItem(@RequestHeader("Authorization") String token, @PathVariable Long productId) {
        String email = jwtTokenProvider.getEmail(token.substring(7));
        wishlistService.deleteWishlistItem(email, productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Void> addWishlistItem( @RequestParam("email") String email, @RequestParam("optionId") Long optionId, @PathVariable Long productId) {
        wishlistService.addWishlistItem(email, optionId, productId);

        return ResponseEntity.ok().build();
    }

}
