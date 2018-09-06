package com.lamaknyo.api.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResComponent {

    public static String productUrl;

    public static String productDir;

    public static String productImgDef;

    @Value("${res.product-url}")
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Value("${res.product-dir}")
    public void setProductDir(String productDir) {
        this.productDir = productDir;
    }

    @Value("${res.product-img-default}")
    public static void setProductImgDef(String productImgDef) {
        ResComponent.productImgDef = productImgDef;
    }
}
