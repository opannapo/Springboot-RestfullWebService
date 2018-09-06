package com.lamaknyo.api.common;

import org.springframework.stereotype.Component;

@Component
public interface UrlComponent {
    interface Product {
        String product = "/product";
        String products_active = "/products/active";
        String products_exclusive = "/products/exclusive";
        String products_promotion = "/products/promotion";
        String products_top = "/products/top";
        String products_filter = "/products/filter";
        String products_of_seller = "/products/of/seller";
        String products_of_category = "/products/of/category";
    }

    interface Seller {
        String seller = "/seller";
        String sellers_active = "/sellers/active";
        String sellers_filter = "/sellers/filter";
        String sellers_of_seller = "/sellers/of/seller";
    }

    interface User {
        String user = "/user";
        String user_auth = "/user/auth";
        String user_signout = "/user/signout";
        String user_edit_privacy_email = "/user/edit/privacy/email";
        String user_edit_privacy_password = "/user/edit/privacy/password";
        String user_edit_privacy_photo = "/user/edit/privacy/photo";
        String user_edit_privacy_address = "/user/edit/privacy/address";
        String user_edit_privacy_basic = "/user/edit/privacy/basic";
    }

    interface Message {
        String message = "/message";
        String messages_of_user = "/messages/of/user";
        String messages_of_me = "/messages/of/me";
    }

    interface Order {
        String order = "/order";
        String orders_active = "/products/active";
        String orders_filter = "/products/filter";
        String orders_of_user = "/products/of/user";
    }
}