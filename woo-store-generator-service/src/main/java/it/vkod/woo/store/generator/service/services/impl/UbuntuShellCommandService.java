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
            Faker faker = new Faker();
            String name = faker.company().name().replaceAll("[^a-zA-Z0-9]", "");
            builder
                    .append("#### Store ").append(name).append(" is generated.").append("\n")
                    .append("wp core download --path=").append(name).append("\n")
                    .append("cd /var/www/html/").append(name).append("\n")
                    .append("wp config create --dbname=").append(name).append("_db --dbuser=webuser --dbpass=password").append("\n")
                    .append("wp db create").append("\n")
                    .append("wp core install --url=http://localhost/").append(name).append(" --title=\"").append(name).append("\" --admin_user=").append("webuser").append(" --admin_password=").append("password").append(" --admin_email=webuser@localhost.wp").append("\n")
                    .append("wp plugin update --all").append("\n")
                    .append("wp plugin install user-switching woocommerce woocommerce-admin --activate").append("\n")
                    .append("wp theme install storefront --activate").append("\n")
                    .append("cd ..").append("\n");

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
