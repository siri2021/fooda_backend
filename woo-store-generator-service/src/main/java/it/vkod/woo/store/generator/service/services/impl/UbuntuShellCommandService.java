package it.vkod.woo.store.generator.service.services.impl;

import com.github.javafaker.Faker;
import it.vkod.woo.store.generator.service.services.ShellCommandService;
import org.springframework.stereotype.Service;

@Service
public class UbuntuShellCommandService implements ShellCommandService {

    @Override
    public String generateDummyStoreCode(final int count) {

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Faker faker =  new Faker();
            String name = faker.company().name().replaceAll("[^a-zA-Z0-9]", "");;

            builder.append("wp core download --path=" + name + "\n" +
                    "cd /var/www/html/" + name + "\n" +
                    "wp config create --dbname=" + name + "_db --dbuser=webuser --dbpass=password\n" +
                    "wp db create\n" +
                    "wp core install --url=http://localhost/" + name + " --title=\"" + name + "\" --admin_user=" + name + " --admin_password=store001 --admin_email=yilmaz.brievenbus@gmail.com\n" +
                    "wp plugin update --all\n" +
                    "wp plugin install user-switching woocommerce woocommerce-admin --activate\n" +
                    "wp theme install storefront --activate\n");

        }

        return builder.toString();
    }

    @Override
    public String generateWpCliInstallationCode() {
        return "curl -O https://raw.githubusercontent.com/wp-cli/builds/gh-pages/phar/wp-cli.phar\n" +
                "chmod +x wp-cli.phar\n" +
                "sudo mv wp-cli.phar /usr/local/bin/wp\n" +
                "wp --info\n";
    }
}
