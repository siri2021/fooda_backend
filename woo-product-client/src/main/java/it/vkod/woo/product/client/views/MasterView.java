package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@PWA(name = "Fooda",
        shortName = "Fooda",
        iconPath = "woo-product-client/src/main/webapp/icons/logo-1024x1024.png")
@UIScope
public class MasterView extends AppLayout {

    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String ICON_SIZE = "28px";

    Tabs tabs;

    @PostConstruct
    public void init() {

        final Icon searchIcon = VaadinIcon.SEARCH.create();
        searchIcon.setSize(ICON_SIZE);
        searchIcon.setColor(TEXT_COLOR);
        searchIcon.getStyle().set("background-color", BG_COLOR);
        final Tab searchTab = new Tab(new Button(searchIcon, click -> {
            UI.getCurrent().navigate("search");
        }));
        searchTab.setSelected(false);
        searchTab.setId("searchTab");

        final Icon cartIcon = VaadinIcon.CART.create();
        cartIcon.setSize(ICON_SIZE);
        cartIcon.setColor(TEXT_COLOR);
        cartIcon.getStyle().set("background-color", BG_COLOR);
        final Tab cartTab = new Tab(new Button(cartIcon, click -> {
            UI.getCurrent().navigate("basket");
        }));
        cartTab.setSelected(false);
        cartTab.setId("cartTab");

        final Icon addressIcon = VaadinIcon.HOME.create();
        addressIcon.setSize(ICON_SIZE);
        addressIcon.setColor(TEXT_COLOR);
        addressIcon.getStyle().set("background-color", BG_COLOR);
        final Tab addressTab = new Tab(new Button(addressIcon, click -> {
            UI.getCurrent().navigate("contact");
        }));
        addressTab.setSelected(false);
        addressTab.setId("addressTab");

        final Icon paymentIcon = VaadinIcon.WALLET.create();
        paymentIcon.setSize(ICON_SIZE);
        paymentIcon.setColor(TEXT_COLOR);
        paymentIcon.getStyle().set("background-color", BG_COLOR);
        final Tab paymentTab = new Tab(new Button(paymentIcon, click -> {
            UI.getCurrent().navigate("payment");
        }));
        paymentTab.setSelected(false);
        paymentTab.setId("paymentTab");

        tabs = new Tabs(
                searchTab,
                cartTab,
                addressTab,
                paymentTab
        );

        tabs.setAutoselect(true);

        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.getStyle().set("background-color", BG_COLOR).set("color", TEXT_COLOR);
        tabs.setSizeFull();

        addToNavbar(true, tabs);
        tabs.setFlexGrowForEnclosedTabs(1);
        this.setPrimarySection(Section.NAVBAR);

    }

    public Tabs getTabs() {
        return tabs;
    }
}