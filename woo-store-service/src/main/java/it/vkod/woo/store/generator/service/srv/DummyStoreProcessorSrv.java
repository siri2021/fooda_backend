package it.vkod.woo.store.generator.service.srv;

public interface DummyStoreProcessorSrv {

    String generateStore(final int count);

    String generatePreInstall();

    String generateStoreProducts(final int count);
}
