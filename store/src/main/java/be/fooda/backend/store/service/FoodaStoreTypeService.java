package be.fooda.backend.store.service;

import java.util.List;

public interface FoodaStoreTypeService<REQ,RES> {
    List<RES> getByType(String title);
}
