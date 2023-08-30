package com.thousandeyes.practice.mugs.cart;

import com.thousandeyes.practice.mugs.mugs.Mug;
import com.thousandeyes.practice.mugs.mugs.MugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("order")
public class CartController {
    private final int CART_ID = 1; // hard coded for now

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MugRepository mugRepository;

    public Mug retrieveMug(int id) {
        return mugRepository.findMugById(id);
    }

    public Cart retrieveCart(int id) {
        return cartRepository.findCartById(id);
    }

    @GetMapping(path = "/cart")
    public String showCartPage(Model model) {
        model.addAttribute("cartTotal",
                String.format("%.2f", retrieveCart(CART_ID).getCartTotal()));
        return "cart";
    }

    public void updateCartTotal(double cartTotal) {
        Cart myCart = retrieveCart(CART_ID);
        myCart.cartTotal = cartTotal;
        cartRepository.save(myCart);
    }

    @PostMapping(path = "/cart")
    public String processOrder(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        updateCartTotal(0);
        return "redirect:/";
    }

    @RequestMapping(path = "/cart/addToCart")
    public String addToCart(Model model, @RequestParam(value = "code", defaultValue = "") String code) {

        model.addAttribute("productCode", code);
        double mugPrice = retrieveMug(Integer.valueOf(code)).getPrice();
        updateCartTotal(retrieveCart(CART_ID).getCartTotal() + mugPrice);

        return "redirect:/mugs";
    }
}
