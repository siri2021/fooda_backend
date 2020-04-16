package it.vkod.woo.website.generator.views;

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

    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";

    Tabs tabs;

    @PostConstruct
    public void init() {

        final Icon contractIcon = VaadinIcon.HANDSHAKE.create();
        contractIcon.setSize("28px");
        contractIcon.setColor(TEXT_COLOR);
        contractIcon.getStyle().set("background-color", BG_COLOR);
        final Tab contractTab = new Tab(new Button(contractIcon, click -> {
            UI.getCurrent().navigate("");
        }));

        final Icon storeInfoIcon = VaadinIcon.SHOP.create();
        storeInfoIcon.setSize("28px");
        storeInfoIcon.setColor(TEXT_COLOR);
        storeInfoIcon.getStyle().set("background-color", BG_COLOR);
        final Tab storeInfoTab = new Tab(new Button(storeInfoIcon, click -> {
            UI.getCurrent().navigate("store");
        }));

        final Icon siteSettingsIcon = VaadinIcon.NEWSPAPER.create();
        siteSettingsIcon.setSize("28px");
        siteSettingsIcon.setColor(TEXT_COLOR);
        siteSettingsIcon.getStyle().set("background-color", BG_COLOR);
        final Tab siteSettingsTab = new Tab(new Button(siteSettingsIcon, click -> {
            UI.getCurrent().navigate("settings");
        }));

        final Icon authKeysIcon = VaadinIcon.KEY.create();
        authKeysIcon.setSize("28px");
        authKeysIcon.setColor(TEXT_COLOR);
        authKeysIcon.getStyle().set("background-color", BG_COLOR);
        final Tab authKeysTab = new Tab(new Button(authKeysIcon, click -> {
            UI.getCurrent().navigate("keys");
        }));

        tabs = new Tabs(
                contractTab,
                storeInfoTab,
                siteSettingsTab,
                authKeysTab
        );

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