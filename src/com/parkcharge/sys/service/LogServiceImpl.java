package com.parkcharge.sys.service;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.log.Log;
import com.persistent.impl.Hibernate3CRUDImpl;

/**
 * 日志记录类
 * 
 * @author 陈捷
 *
 */
@Service
public class LogServiceImpl extends Hibernate3CRUDImpl<Log> implements LogService {

}
