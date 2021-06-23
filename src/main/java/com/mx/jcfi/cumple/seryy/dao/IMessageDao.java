package com.mx.jcfi.cumple.seryy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mx.jcfi.cumple.seryy.entity.Message;

public interface IMessageDao extends PagingAndSortingRepository<Message, Long> {

}
