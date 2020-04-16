package it.vkod.woo.store.generator.service.controllers;

import it.vkod.woo.store.generator.service.services.impl.UbuntuShellCommandService;
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

@RequestMapping("api/dummy/stores")
@RestController
public class UbuntuShellCommandCtrl {

    @Autowired
    private UbuntuShellCommandService service;

    @GetMapping("{numberOfStores}")
    public byte[] getShellScripts(@PathVariable("numberOfStores") final int numberOfStores) throws IOException {
        FileOutputStream out = new FileOutputStream(new File("./wp-dummy-stores.sh"));
        IOUtils.write(service.generateDummyStoreCode(numberOfStores), out);
        out.flush();
        out.close();

        FileInputStream in = new FileInputStream("./wp-dummy-stores.sh");
        return IOUtils.toByteArray(in);
    }

}
