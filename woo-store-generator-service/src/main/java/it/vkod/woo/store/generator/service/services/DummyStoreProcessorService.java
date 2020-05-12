package it.vkod.woo.store.generator.service.services;

public interface DummyStoreProcessorService {

    String generateStore(final int count);

    String generatePreInstall();

    String generateStoreProducts(final int count);
}
