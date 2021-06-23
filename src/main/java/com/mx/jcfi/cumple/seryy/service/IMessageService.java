package com.mx.jcfi.cumple.seryy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mx.jcfi.cumple.seryy.entity.Message;

public interface IMessageService {
	
	public void save(Message mensaje);
	public Page <Message> findAll(Pageable pageable);

}
