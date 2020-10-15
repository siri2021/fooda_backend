package be.fooda.backend.store.service;

import java.util.List;

public interface FoodaStoreDeliveryLocationsService<REQ,RES> {
    List<RES> getByDeliveryLocation(final Long municipalityId);

    List<RES> getStoreByDeliveryTime(final Integer timeAsMinutes);
}
