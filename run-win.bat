start cmd /k "java -jar woo-discovery-service/target/woo-discovery-service-0.0.1-SNAPSHOT.jar"
timeout 10
start cmd /k "java -jar woo-auth-service/target/woo-auth-service-0.0.1-SNAPSHOT.jar"
start cmd /k "java -jar woo-product-service/target/woo-product-service-0.0.1-SNAPSHOT.jar"
timeout 10
start cmd /k "java -jar woo-basket-service/target/woo-basket-service-0.0.1-SNAPSHOT.jar"
start cmd /k "java -jar woo-order-service/target/woo-order-service-0.0.1-SNAPSHOT.jar"
start cmd /k "java -jar woo-matching-service/target/woo-matching-service-0.0.1-SNAPSHOT.jar"
timeout 10
start cmd /k "java -jar woo-product-client/target/woo-product-client-1.0-SNAPSHOT.jar"
start cmd /k "java -jar woo-store-service/target/woo-store-service-0.0.1-SNAPSHOT.jar"
start cmd /k "java -jar woo-store-client/target/woo-store-client-0.0.1-SNAPSHOT.jar"
timeout 10
start cmd /k "ngrok http 8888"
