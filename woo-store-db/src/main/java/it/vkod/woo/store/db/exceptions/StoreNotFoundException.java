package it.vkod.woo.store.db.exceptions;

public class StoreNotFoundException extends NullPointerException {

    public StoreNotFoundException() {
        super("Store Not Found");
    }
}
