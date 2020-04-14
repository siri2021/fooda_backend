package it.vkod.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
public class MasterView extends AppLayout {

    Tabs tabs;

    @PostConstruct
    public void init() {

        final Icon searchIcon = VaadinIcon.SEARCH.create();
        searchIcon.setSize("28px");
        searchIcon.getStyle().set("background-color", "white");
        final Tab searchTab = new Tab(new Button(searchIcon, click -> {
            UI.getCurrent().navigate("search");
        }));
        searchTab.setId("searchTab");

        final Icon cartIcon = VaadinIcon.CART.create();
        cartIcon.setSize("28px");
        cartIcon.getStyle().set("background-color", "white");
        final Tab cartTab = new Tab(new Button(cartIcon, click -> {
            UI.getCurrent().navigate("cart");
        }));
        cartTab.setId("cartTab");

        final Icon addressIcon = VaadinIcon.HOME.create();
        addressIcon.setSize("28px");
        addressIcon.getStyle().set("background-color", "white");
        final Tab addressTab = new Tab(new Button(addressIcon, click -> {
            UI.getCurrent().navigate("address");
        }));
        addressTab.setId("addressTab");

        final Icon paymentIcon = VaadinIcon.MONEY.create();
        paymentIcon.setSize("28px");
        paymentIcon.getStyle().set("background-color", "white");
        final Tab paymentTab = new Tab(new Button(paymentIcon, click -> {
            UI.getCurrent().navigate("payment");
        }));
        paymentTab.setId("paymentTab");

        tabs = new Tabs(
                searchTab,
                cartTab,
                addressTab,
                paymentTab
        );

        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.getStyle().set("background-color", "white");
        tabs.setSizeFull();

        addToNavbar(true, tabs);
        tabs.setFlexGrowForEnclosedTabs(1);
        this.setPrimarySection(Section.NAVBAR);

    }

    public Tabs getTabs() {
        return tabs;
    }
}