package it.vkod.woo.product.client.views;

public enum  DesignConstants {

    BACKGROUND_COLOR("#3333FF"),
    FONT_COLOR("#FFFFFF");


    private final String cssValue;

    DesignConstants(String cssValue) {
        this.cssValue = cssValue;
    }

    public String getCssValue() {
        return cssValue;
    }
}
