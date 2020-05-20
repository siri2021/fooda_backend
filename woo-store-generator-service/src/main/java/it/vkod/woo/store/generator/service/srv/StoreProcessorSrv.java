package it.vkod.woo.store.generator.service.srv;

import it.vkod.woo.store.generator.service.pojo.store.req.StoreRequest;

public interface StoreProcessorSrv {

    String generateStore(StoreRequest storeRequest);

    String generatePreInstall();

    String generateStoreProducts(final int count);


}
