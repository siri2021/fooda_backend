package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
//@PWA(name = "Fooda", shortName = "Fooda")
@UIScope
@SpringComponent
@CssImport("./styles/responsive.css")
public class MasterView extends AppLayout {

    private final String BG_COLOR = "#3333FF";
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
        searchTab.getStyle().set("background-color", BG_COLOR);
        searchTab.setId("searchTab");

        final Icon cartIcon = VaadinIcon.CART.create();
        cartIcon.setSize(ICON_SIZE);
        cartIcon.setColor(TEXT_COLOR);
        cartIcon.getStyle().set("background-color", BG_COLOR);
        final Tab cartTab = new Tab(new Button(cartIcon, click -> {
            UI.getCurrent().navigate("basket");
        }));
        cartTab.setSelected(false);
        cartTab.getStyle().set("background-color", BG_COLOR);
        cartTab.setId("cartTab");

        final Icon addressIcon = VaadinIcon.HOME.create();
        addressIcon.setSize(ICON_SIZE);
        addressIcon.setColor(TEXT_COLOR);
        addressIcon.getStyle().set("background-color", BG_COLOR);
        final Tab addressTab = new Tab(new Button(addressIcon, click -> {
            UI.getCurrent().navigate("contact");
        }));
        addressTab.setSelected(false);
        addressTab.getStyle().set("background-color", BG_COLOR);
        addressTab.setId("addressTab");

        final Icon paymentIcon = VaadinIcon.WALLET.create();
        paymentIcon.setSize(ICON_SIZE);
        paymentIcon.setColor(TEXT_COLOR);
        paymentIcon.getStyle().set("background-color", BG_COLOR);
        final Tab paymentTab = new Tab(new Button(paymentIcon, click -> {
            UI.getCurrent().navigate("payment");
        }));
        paymentTab.setSelected(false);
        paymentTab.getStyle().set("background-color", BG_COLOR);
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