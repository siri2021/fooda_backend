package it.vkod.woo.store.generator.service.controllers;

import it.vkod.woo.store.generator.service.services.impl.UbuntuDummyStoreProcessorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RequestMapping("api/generate/")
@RestController
public class UbuntuShellCommandCtrl {

    @Autowired
    private UbuntuDummyStoreProcessorService service;

    @GetMapping("preinstall")
    public byte[] apiGetPreInstallScripts() throws IOException {
        FileOutputStream out = new FileOutputStream(new File("./pre.sh"));
        IOUtils.write(service.generatePreInstall(), out);
        out.flush();
        out.close();

        FileInputStream in = new FileInputStream("./pre.sh");
        return IOUtils.toByteArray(in);
    }

    @GetMapping("stores/{count}")
    public byte[] apiGetStoreScripts(@PathVariable("count") final int count) throws IOException {
        FileOutputStream out = new FileOutputStream(new File("./stores.sh"));
        IOUtils.write(service.generateStore(count), out);
        out.flush();
        out.close();

        FileInputStream in = new FileInputStream("./stores.sh");
        return IOUtils.toByteArray(in);
    }

    @GetMapping("products/{count}")
    public byte[] apiGetProductScripts(@PathVariable("count") final int count) throws IOException {
        FileOutputStream out = new FileOutputStream(new File("./products.sh"));
        IOUtils.write(service.generateStoreProducts(count), out);
        out.flush();
        out.close();

        FileInputStream in = new FileInputStream("./products.sh");
        return IOUtils.toByteArray(in);
    }

}
