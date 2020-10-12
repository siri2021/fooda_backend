package be.fooda.backend.contact.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.fooda.backend.commons.model.template.contact.request.FoodaContactReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaContactRes;
import be.fooda.backend.commons.service.mapper.FoodaContactHttpMapper;
import be.fooda.backend.contact.dao.FoodaContactRepository;
import be.fooda.backend.contact.service.FoodaContactService;
import be.fooda.backend.contact.service.mapper.FoodaContactDtoMapper;

@Service
public class FoodaContactServiceImpl implements FoodaContactService<FoodaContactReq, FoodaContactRes>{

    @Autowired
    private FoodaContactRepository contactRepository;

    @Autowired
    private FoodaContactDtoMapper dtoMapper;

    @Autowired
    private FoodaContactHttpMapper httpMapper;

	@Override
	public Optional<FoodaContactRes> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaContactRes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> getByExample(FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaContactRes> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> add(FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> editById(Long id, FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> editByExample(FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> removeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaContactRes> removeByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaContactRes> removeByExample(FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existsByExample(FoodaContactReq req) {
		// TODO Auto-generated method stub
		return null;
	}

    

}
