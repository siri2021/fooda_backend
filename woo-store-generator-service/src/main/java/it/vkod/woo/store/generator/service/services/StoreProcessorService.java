package it.vkod.woo.store.generator.service.services;

import it.vkod.woo.store.generator.service.payloads.StoreRequest;

public interface StoreProcessorService {

    String generateStore(StoreRequest storeRequest);

    String generatePreInstall();

    String generateStoreProducts(final int count);


}
