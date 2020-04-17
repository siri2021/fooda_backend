package it.vkod.woo.store.generator.service.services;

public interface ShellCommandService {

    String generateDummyStoreCode(final int count);

    String generateWpCliInstallationCode();

    String generateDummyProductsScript(final int count);
}
