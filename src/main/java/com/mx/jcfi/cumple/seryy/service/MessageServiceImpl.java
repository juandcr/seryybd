package com.mx.jcfi.cumple.seryy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mx.jcfi.cumple.seryy.dao.IMessageDao;
import com.mx.jcfi.cumple.seryy.entity.Message;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	IMessageDao dao;

	@Override
	public void save(Message mensaje) {
		dao.save(mensaje);		
	}

	@Override
	public Page<Message> findAll(Pageable pageable) {
		return dao.findAll(pageable);		
	}
	

}
