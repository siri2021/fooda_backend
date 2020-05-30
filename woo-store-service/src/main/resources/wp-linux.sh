wp core download --path=store001
cd store001
wp config create --dbname=store001_db --dbuser=webuser --dbpass=password
wp db create
wp core install --url=http://localhost/store001 --title="Store 0001" --admin_user=store001 --admin_password=store001 --admin_email=yilmaz.brievenbus@gmail.com
wp plugin update --all
wp plugin install user-switching woocommerce woocommerce-admin --activate
wp theme install storefront --activate
