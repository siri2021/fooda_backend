#### Store LebsackInc is generated.
wp core download --path=LebsackInc
cd /var/www/html/LebsackInc
wp config create --dbname=LebsackInc_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/LebsackInc --title="LebsackInc" --admin_user=webuser --admin_password=password --admin_email=webuser@localhost.wp
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
cd ..
#### Store KrisLarkinandSanford is generated.
wp core download --path=KrisLarkinandSanford
cd /var/www/html/KrisLarkinandSanford
wp config create --dbname=KrisLarkinandSanford_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/KrisLarkinandSanford --title="KrisLarkinandSanford" --admin_user=webuser --admin_password=password --admin_email=webuser@localhost.wp
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
cd ..
