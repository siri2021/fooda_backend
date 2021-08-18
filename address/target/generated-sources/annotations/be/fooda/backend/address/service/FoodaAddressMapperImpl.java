package be.fooda.backend.address.service;

import be.fooda.backend.address.model.entity.FoodaAddress;
import be.fooda.backend.address.model.entity.FoodaAddressCoordinates;
import be.fooda.backend.address.model.entity.FoodaAddressUser;
import be.fooda.backend.commons.model.address.create.FoodaAddressCoordinatesCreate;
import be.fooda.backend.commons.model.address.create.FoodaAddressCreate;
import be.fooda.backend.commons.model.address.create.FoodaAddressUserCreate;
import be.fooda.backend.commons.model.address.read.FoodaAddressCoordinatesExample;
import be.fooda.backend.commons.model.address.read.FoodaAddressExample;
import be.fooda.backend.commons.model.address.read.FoodaAddressUserExample;
import be.fooda.backend.commons.model.address.update.FoodaAddressCoordinatesUpdate;
import be.fooda.backend.commons.model.address.update.FoodaAddressUpdate;
import be.fooda.backend.commons.model.address.update.FoodaAddressUserUpdate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-20T23:06:11+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class FoodaAddressMapperImpl implements FoodaAddressMapper {

    @Override
    public FoodaAddress fromCreateToEntity(FoodaAddressCreate from) {
        if ( from == null ) {
            return null;
        }

        FoodaAddress foodaAddress = new FoodaAddress();

        foodaAddress.setUser( foodaAddressUserCreateToFoodaAddressUser( from.getUser() ) );
        foodaAddress.setDoor( from.getDoor() );
        foodaAddress.setHouse( from.getHouse() );
        foodaAddress.setStreet( from.getStreet() );
        foodaAddress.setIsActive( from.getIsActive() );
        foodaAddress.setRegistryTime( from.getRegistryTime() );
        foodaAddress.setUpdateTime( from.getUpdateTime() );
        foodaAddress.setTitle( from.getTitle() );
        foodaAddress.setIsCurrent( from.getIsCurrent() );
        foodaAddress.setCoordinates( foodaAddressCoordinatesCreateToFoodaAddressCoordinates( from.getCoordinates() ) );
        foodaAddress.setMunicipality( from.getMunicipality() );
        foodaAddress.setPostcode( from.getPostcode() );
        foodaAddress.setCity( from.getCity() );
        foodaAddress.setRegion( from.getRegion() );
        foodaAddress.setCountry( from.getCountry() );
        foodaAddress.setCountryCode( from.getCountryCode() );

        return foodaAddress;
    }

    @Override
    public FoodaAddress fromUpdateToEntity(FoodaAddressUpdate from, FoodaAddress to) {
        if ( from == null ) {
            return null;
        }

        if ( from.getUser() != null ) {
            if ( to.getUser() == null ) {
                to.setUser( new FoodaAddressUser() );
            }
            foodaAddressUserUpdateToFoodaAddressUser( from.getUser(), to.getUser() );
        }
        if ( from.getDoor() != null ) {
            to.setDoor( from.getDoor() );
        }
        if ( from.getHouse() != null ) {
            to.setHouse( from.getHouse() );
        }
        if ( from.getStreet() != null ) {
            to.setStreet( from.getStreet() );
        }
        if ( from.getTitle() != null ) {
            to.setTitle( from.getTitle() );
        }
        if ( from.getIsCurrent() != null ) {
            to.setIsCurrent( from.getIsCurrent() );
        }
        if ( from.getCoordinates() != null ) {
            if ( to.getCoordinates() == null ) {
                to.setCoordinates( new FoodaAddressCoordinates() );
            }
            foodaAddressCoordinatesUpdateToFoodaAddressCoordinates( from.getCoordinates(), to.getCoordinates() );
        }
        if ( from.getMunicipality() != null ) {
            to.setMunicipality( from.getMunicipality() );
        }
        if ( from.getPostcode() != null ) {
            to.setPostcode( from.getPostcode() );
        }
        if ( from.getCity() != null ) {
            to.setCity( from.getCity() );
        }
        if ( from.getRegion() != null ) {
            to.setRegion( from.getRegion() );
        }
        if ( from.getCountry() != null ) {
            to.setCountry( from.getCountry() );
        }
        if ( from.getCountryCode() != null ) {
            to.setCountryCode( from.getCountryCode() );
        }

        return to;
    }

    @Override
    public FoodaAddress fromExampleToEntity(FoodaAddressExample from) {
        if ( from == null ) {
            return null;
        }

        FoodaAddress foodaAddress = new FoodaAddress();

        foodaAddress.setUser( foodaAddressUserExampleToFoodaAddressUser( from.getUser() ) );
        foodaAddress.setDoor( from.getDoor() );
        foodaAddress.setHouse( from.getHouse() );
        foodaAddress.setStreet( from.getStreet() );
        foodaAddress.setTitle( from.getTitle() );
        foodaAddress.setIsCurrent( from.getIsCurrent() );
        foodaAddress.setCoordinates( foodaAddressCoordinatesExampleToFoodaAddressCoordinates( from.getCoordinates() ) );
        foodaAddress.setMunicipality( from.getMunicipality() );
        foodaAddress.setPostcode( from.getPostcode() );
        foodaAddress.setCity( from.getCity() );
        foodaAddress.setRegion( from.getRegion() );
        foodaAddress.setCountry( from.getCountry() );
        foodaAddress.setCountryCode( from.getCountryCode() );

        return foodaAddress;
    }

    @Override
    public FoodaAddressCreate fromEntityToCreate(FoodaAddress from) {
        if ( from == null ) {
            return null;
        }

        FoodaAddressCreate foodaAddressCreate = new FoodaAddressCreate();

        foodaAddressCreate.setDoor( from.getDoor() );
        foodaAddressCreate.setHouse( from.getHouse() );
        foodaAddressCreate.setStreet( from.getStreet() );
        foodaAddressCreate.setIsActive( from.getIsActive() );
        foodaAddressCreate.setTitle( from.getTitle() );
        foodaAddressCreate.setIsCurrent( from.getIsCurrent() );
        foodaAddressCreate.setRegistryTime( from.getRegistryTime() );
        foodaAddressCreate.setUpdateTime( from.getUpdateTime() );
        foodaAddressCreate.setUser( foodaAddressUserToFoodaAddressUserCreate( from.getUser() ) );
        foodaAddressCreate.setCoordinates( foodaAddressCoordinatesToFoodaAddressCoordinatesCreate( from.getCoordinates() ) );
        foodaAddressCreate.setMunicipality( from.getMunicipality() );
        foodaAddressCreate.setPostcode( from.getPostcode() );
        foodaAddressCreate.setCity( from.getCity() );
        foodaAddressCreate.setRegion( from.getRegion() );
        foodaAddressCreate.setCountry( from.getCountry() );
        foodaAddressCreate.setCountryCode( from.getCountryCode() );

        return foodaAddressCreate;
    }

    @Override
    public FoodaAddressUpdate fromEntityToUpdate(FoodaAddress from, FoodaAddressUpdate to) {
        if ( from == null ) {
            return null;
        }

        if ( from.getDoor() != null ) {
            to.setDoor( from.getDoor() );
        }
        if ( from.getHouse() != null ) {
            to.setHouse( from.getHouse() );
        }
        if ( from.getStreet() != null ) {
            to.setStreet( from.getStreet() );
        }
        if ( from.getTitle() != null ) {
            to.setTitle( from.getTitle() );
        }
        if ( from.getIsCurrent() != null ) {
            to.setIsCurrent( from.getIsCurrent() );
        }
        if ( from.getUser() != null ) {
            if ( to.getUser() == null ) {
                to.setUser( new FoodaAddressUserUpdate() );
            }
            foodaAddressUserToFoodaAddressUserUpdate( from.getUser(), to.getUser() );
        }
        if ( from.getMunicipality() != null ) {
            to.setMunicipality( from.getMunicipality() );
        }
        if ( from.getPostcode() != null ) {
            to.setPostcode( from.getPostcode() );
        }
        if ( from.getCity() != null ) {
            to.setCity( from.getCity() );
        }
        if ( from.getRegion() != null ) {
            to.setRegion( from.getRegion() );
        }
        if ( from.getCountry() != null ) {
            to.setCountry( from.getCountry() );
        }
        if ( from.getCountryCode() != null ) {
            to.setCountryCode( from.getCountryCode() );
        }
        if ( from.getCoordinates() != null ) {
            if ( to.getCoordinates() == null ) {
                to.setCoordinates( new FoodaAddressCoordinatesUpdate() );
            }
            foodaAddressCoordinatesToFoodaAddressCoordinatesUpdate( from.getCoordinates(), to.getCoordinates() );
        }

        return to;
    }

    @Override
    public FoodaAddressExample fromEntityToExample(FoodaAddress from) {
        if ( from == null ) {
            return null;
        }

        FoodaAddressExample foodaAddressExample = new FoodaAddressExample();

        foodaAddressExample.setDoor( from.getDoor() );
        foodaAddressExample.setHouse( from.getHouse() );
        foodaAddressExample.setStreet( from.getStreet() );
        foodaAddressExample.setTitle( from.getTitle() );
        foodaAddressExample.setIsCurrent( from.getIsCurrent() );
        foodaAddressExample.setUser( foodaAddressUserToFoodaAddressUserExample( from.getUser() ) );
        foodaAddressExample.setCoordinates( foodaAddressCoordinatesToFoodaAddressCoordinatesExample( from.getCoordinates() ) );
        foodaAddressExample.setMunicipality( from.getMunicipality() );
        foodaAddressExample.setPostcode( from.getPostcode() );
        foodaAddressExample.setCity( from.getCity() );
        foodaAddressExample.setRegion( from.getRegion() );
        foodaAddressExample.setCountry( from.getCountry() );
        foodaAddressExample.setCountryCode( from.getCountryCode() );

        return foodaAddressExample;
    }

    @Override
    public FoodaAddressExample fromEntityToResponse(FoodaAddress from) {
        if ( from == null ) {
            return null;
        }

        FoodaAddressExample foodaAddressExample = new FoodaAddressExample();

        foodaAddressExample.setDoor( from.getDoor() );
        foodaAddressExample.setHouse( from.getHouse() );
        foodaAddressExample.setStreet( from.getStreet() );
        foodaAddressExample.setTitle( from.getTitle() );
        foodaAddressExample.setIsCurrent( from.getIsCurrent() );
        foodaAddressExample.setUser( foodaAddressUserToFoodaAddressUserExample( from.getUser() ) );
        foodaAddressExample.setCoordinates( foodaAddressCoordinatesToFoodaAddressCoordinatesExample( from.getCoordinates() ) );
        foodaAddressExample.setMunicipality( from.getMunicipality() );
        foodaAddressExample.setPostcode( from.getPostcode() );
        foodaAddressExample.setCity( from.getCity() );
        foodaAddressExample.setRegion( from.getRegion() );
        foodaAddressExample.setCountry( from.getCountry() );
        foodaAddressExample.setCountryCode( from.getCountryCode() );

        return foodaAddressExample;
    }

    protected FoodaAddressUser foodaAddressUserCreateToFoodaAddressUser(FoodaAddressUserCreate foodaAddressUserCreate) {
        if ( foodaAddressUserCreate == null ) {
            return null;
        }

        FoodaAddressUser foodaAddressUser = new FoodaAddressUser();

        foodaAddressUser.setExternalUserId( foodaAddressUserCreate.getExternalUserId() );
        foodaAddressUser.setUsername( foodaAddressUserCreate.getUsername() );

        return foodaAddressUser;
    }

    protected FoodaAddressCoordinates foodaAddressCoordinatesCreateToFoodaAddressCoordinates(FoodaAddressCoordinatesCreate foodaAddressCoordinatesCreate) {
        if ( foodaAddressCoordinatesCreate == null ) {
            return null;
        }

        FoodaAddressCoordinates foodaAddressCoordinates = new FoodaAddressCoordinates();

        foodaAddressCoordinates.setLatitude( foodaAddressCoordinatesCreate.getLatitude() );
        foodaAddressCoordinates.setLongitude( foodaAddressCoordinatesCreate.getLongitude() );

        return foodaAddressCoordinates;
    }

    protected void foodaAddressUserUpdateToFoodaAddressUser(FoodaAddressUserUpdate foodaAddressUserUpdate, FoodaAddressUser mappingTarget) {
        if ( foodaAddressUserUpdate == null ) {
            return;
        }

        if ( foodaAddressUserUpdate.getExternalUserId() != null ) {
            mappingTarget.setExternalUserId( foodaAddressUserUpdate.getExternalUserId() );
        }
        if ( foodaAddressUserUpdate.getUsername() != null ) {
            mappingTarget.setUsername( foodaAddressUserUpdate.getUsername() );
        }
    }

    protected void foodaAddressCoordinatesUpdateToFoodaAddressCoordinates(FoodaAddressCoordinatesUpdate foodaAddressCoordinatesUpdate, FoodaAddressCoordinates mappingTarget) {
        if ( foodaAddressCoordinatesUpdate == null ) {
            return;
        }

        if ( foodaAddressCoordinatesUpdate.getLatitude() != null ) {
            mappingTarget.setLatitude( foodaAddressCoordinatesUpdate.getLatitude() );
        }
        if ( foodaAddressCoordinatesUpdate.getLongitude() != null ) {
            mappingTarget.setLongitude( foodaAddressCoordinatesUpdate.getLongitude() );
        }
    }

    protected FoodaAddressUser foodaAddressUserExampleToFoodaAddressUser(FoodaAddressUserExample foodaAddressUserExample) {
        if ( foodaAddressUserExample == null ) {
            return null;
        }

        FoodaAddressUser foodaAddressUser = new FoodaAddressUser();

        foodaAddressUser.setExternalUserId( foodaAddressUserExample.getExternalUserId() );
        foodaAddressUser.setUsername( foodaAddressUserExample.getUsername() );

        return foodaAddressUser;
    }

    protected FoodaAddressCoordinates foodaAddressCoordinatesExampleToFoodaAddressCoordinates(FoodaAddressCoordinatesExample foodaAddressCoordinatesExample) {
        if ( foodaAddressCoordinatesExample == null ) {
            return null;
        }

        FoodaAddressCoordinates foodaAddressCoordinates = new FoodaAddressCoordinates();

        foodaAddressCoordinates.setLatitude( foodaAddressCoordinatesExample.getLatitude() );
        foodaAddressCoordinates.setLongitude( foodaAddressCoordinatesExample.getLongitude() );

        return foodaAddressCoordinates;
    }

    protected FoodaAddressUserCreate foodaAddressUserToFoodaAddressUserCreate(FoodaAddressUser foodaAddressUser) {
        if ( foodaAddressUser == null ) {
            return null;
        }

        FoodaAddressUserCreate foodaAddressUserCreate = new FoodaAddressUserCreate();

        foodaAddressUserCreate.setExternalUserId( foodaAddressUser.getExternalUserId() );
        foodaAddressUserCreate.setUsername( foodaAddressUser.getUsername() );

        return foodaAddressUserCreate;
    }

    protected FoodaAddressCoordinatesCreate foodaAddressCoordinatesToFoodaAddressCoordinatesCreate(FoodaAddressCoordinates foodaAddressCoordinates) {
        if ( foodaAddressCoordinates == null ) {
            return null;
        }

        FoodaAddressCoordinatesCreate foodaAddressCoordinatesCreate = new FoodaAddressCoordinatesCreate();

        foodaAddressCoordinatesCreate.setLatitude( foodaAddressCoordinates.getLatitude() );
        foodaAddressCoordinatesCreate.setLongitude( foodaAddressCoordinates.getLongitude() );

        return foodaAddressCoordinatesCreate;
    }

    protected void foodaAddressUserToFoodaAddressUserUpdate(FoodaAddressUser foodaAddressUser, FoodaAddressUserUpdate mappingTarget) {
        if ( foodaAddressUser == null ) {
            return;
        }

        if ( foodaAddressUser.getExternalUserId() != null ) {
            mappingTarget.setExternalUserId( foodaAddressUser.getExternalUserId() );
        }
        if ( foodaAddressUser.getUsername() != null ) {
            mappingTarget.setUsername( foodaAddressUser.getUsername() );
        }
    }

    protected void foodaAddressCoordinatesToFoodaAddressCoordinatesUpdate(FoodaAddressCoordinates foodaAddressCoordinates, FoodaAddressCoordinatesUpdate mappingTarget) {
        if ( foodaAddressCoordinates == null ) {
            return;
        }

        if ( foodaAddressCoordinates.getLatitude() != null ) {
            mappingTarget.setLatitude( foodaAddressCoordinates.getLatitude() );
        }
        if ( foodaAddressCoordinates.getLongitude() != null ) {
            mappingTarget.setLongitude( foodaAddressCoordinates.getLongitude() );
        }
    }

    protected FoodaAddressUserExample foodaAddressUserToFoodaAddressUserExample(FoodaAddressUser foodaAddressUser) {
        if ( foodaAddressUser == null ) {
            return null;
        }

        FoodaAddressUserExample foodaAddressUserExample = new FoodaAddressUserExample();

        foodaAddressUserExample.setExternalUserId( foodaAddressUser.getExternalUserId() );
        foodaAddressUserExample.setUsername( foodaAddressUser.getUsername() );

        return foodaAddressUserExample;
    }

    protected FoodaAddressCoordinatesExample foodaAddressCoordinatesToFoodaAddressCoordinatesExample(FoodaAddressCoordinates foodaAddressCoordinates) {
        if ( foodaAddressCoordinates == null ) {
            return null;
        }

        FoodaAddressCoordinatesExample foodaAddressCoordinatesExample = new FoodaAddressCoordinatesExample();

        foodaAddressCoordinatesExample.setLatitude( foodaAddressCoordinates.getLatitude() );
        foodaAddressCoordinatesExample.setLongitude( foodaAddressCoordinates.getLongitude() );

        return foodaAddressCoordinatesExample;
    }
}
