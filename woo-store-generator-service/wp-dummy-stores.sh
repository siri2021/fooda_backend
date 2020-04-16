wp core download --path=TrantowDooleyandTerry
cd /var/www/html/TrantowDooleyandTerry
wp config create --dbname=TrantowDooleyandTerry_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/TrantowDooleyandTerry --title="TrantowDooleyandTerry" --admin_user=TrantowDooleyandTerry --admin_password=store001 --admin_email=yilmaz.brievenbus@gmail.com
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
wp core download --path=FeestWisozk
cd /var/www/html/FeestWisozk
wp config create --dbname=FeestWisozk_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/FeestWisozk --title="FeestWisozk" --admin_user=FeestWisozk --admin_password=store001 --admin_email=yilmaz.brievenbus@gmail.com
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
wp core download --path=ToyHansen
cd /var/www/html/ToyHansen
wp config create --dbname=ToyHansen_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/ToyHansen --title="ToyHansen" --admin_user=ToyHansen --admin_password=store001 --admin_email=yilmaz.brievenbus@gmail.com
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
