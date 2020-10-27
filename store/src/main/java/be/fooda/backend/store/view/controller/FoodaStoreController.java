package be.fooda.backend.store.view.controller;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.service.FoodaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/store")
public class FoodaStoreController {

    @Autowired
    private FoodaStoreService<FoodaStoreReq, FoodaStoreRes> storeService;

    @GetMapping("apiStoreGetByStoreId")
    public ResponseEntity<FoodaStoreRes> apiStoreGetByStoreId(@RequestParam final Long storeId) {
        return storeService.getById(storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiStoreGetByStoreExample")
    public ResponseEntity<FoodaStoreRes> apiStoreGetByStoreExample(@RequestParam final FoodaStoreReq storeExample) {
        return storeService.getByExample(storeExample)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetAllStores")
    public ResponseEntity<List<FoodaStoreRes>> apiGetAllStores() {
        return new ResponseEntity<>(storeService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByName")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByName(@RequestParam final String name) {
        return new ResponseEntity<>(storeService.getByName(name), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByAddress")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByAddress(@RequestParam final Set<Long> idSet) {
        return new ResponseEntity<>(storeService.getByAddressId(idSet), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByTypeId")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByType(@RequestParam final String title) {
        return new ResponseEntity<>(storeService.getByType(title), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByParentId")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByParentId(@RequestParam final Long parentId) {
        return new ResponseEntity<>(storeService.getByParent(parentId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByAbout")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByTypeId(@RequestParam final String about) {
        return new ResponseEntity<>(storeService.getByAbout(about), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByAuth")
    public ResponseEntity<FoodaStoreRes> apiGetStoreByAuth(@RequestParam final String key, @RequestParam final String secret, @RequestParam final Long storeId) {
        return storeService.getByAuth(key, secret, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetStoreByWorkingHours")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByWorkingHours(@RequestParam final LocalDate date, @RequestParam final LocalDateTime opens, @RequestParam final LocalDateTime closes) {
        if(date == null )
            return new ResponseEntity<>(storeService.getByWorkingHours( opens, closes), HttpStatus.FOUND);
        else
            return new ResponseEntity<>(storeService.getByWorkingHours(date, opens, closes), HttpStatus.FOUND);
    }



    @GetMapping("apiGetStoreByDeliveryLocation")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByDeliveryLoc(@RequestParam final Long municipalityId) {
        return new ResponseEntity<>(storeService.getByDeliveryLocation(municipalityId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByDeliveryTime")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByDeliveryTime(@RequestParam final Integer timeAsMinutes) {
        return new ResponseEntity<>(storeService.getStoreByDeliveryTime(timeAsMinutes), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByDeliveryCost")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByDeliveryCost(@RequestParam final BigDecimal minPrice, @RequestParam final BigDecimal maxPrice, @RequestParam BigDecimal amount) {
        return new ResponseEntity<>(storeService.getStoreByDeliveryCost(minPrice, maxPrice, amount), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByDeliverycostRange")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByDeliveryCostRange(@RequestParam final BigDecimal minPrice, @RequestParam final BigDecimal maxPrice) {
        return new ResponseEntity<>(storeService.getStoreByDeliveryCost(minPrice, maxPrice), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByPaymentMethod")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByPaymentMethod(@RequestParam final Long paymentMethodId, @RequestParam final BigDecimal minOrderAmount) {
        return new ResponseEntity<>(storeService.getStoreByPaymentMethodId(paymentMethodId, minOrderAmount), HttpStatus.FOUND);
    }

    @GetMapping("apiGetStoreByPaymentMethodId")
    public ResponseEntity<List<FoodaStoreRes>> apiGetStoreByPaymentMethodId(@RequestParam final Long paymentMethodId) {
        return new ResponseEntity<>(storeService.getStoreByPaymentMethodId(paymentMethodId), HttpStatus.FOUND);
    }

   /* @DeleteMapping("apiOrderRemoveByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderById(@RequestParam Long orderId) {
        return orderService.removeById(orderId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    @PostMapping("apiAddStore")
    public ResponseEntity<FoodaStoreRes> apiAddStore(@RequestBody FoodaStoreReq storeReq) {
        return storeService.doesStoreExistByExample(storeReq).equals(Boolean.FALSE)
                ? new ResponseEntity<>(storeService.addStore(storeReq), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apieditStoreById")
    public ResponseEntity<FoodaStoreRes> apieditStoreById(@RequestParam final Long storeId, @RequestParam final FoodaStoreReq storeReq) {
        return storeService.editStoreById(storeId, storeReq)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apieditStoreExample")
    public ResponseEntity<FoodaStoreRes> apieditStoreByExample(@RequestParam final FoodaStoreReq storeReq) {
        return storeService.editStoreByExample(storeReq)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiDeleteStoreById")
    public ResponseEntity<FoodaStoreRes> apiOrderRemoveStoreById(@RequestParam final Long storeId) {
        return storeService.removeStoreById(storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiDeleteStoreByExample")
    public ResponseEntity<FoodaStoreRes> apiOrderRemoveStoreByExample(@RequestParam final FoodaStoreReq storeReq) {
        return storeService.removeStoreByExample(storeReq)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*

private final Fooda[ModuleName]Repository moduleNameRepo;
private final Fooda[ModuleNameChild01]Repository moduleNameChild01Repo;

@GetMapping(“/getAll”)
public List<Fooda[ModuleName]Res> api[Module]GetAll(Object obj){

    final Fooda[ModuleName]Dto parent = moduleNameRepo.save(obj);

    order.getChild().setParent(obj);
    moduleNameChild01Repo.save(obj.getChild01());

}





     */


}