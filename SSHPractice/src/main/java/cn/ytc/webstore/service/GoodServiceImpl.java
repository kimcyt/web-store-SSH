package cn.ytc.webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ytc.webstore.dao.GoodDaoImpl;
import cn.ytc.webstore.dao.UserDaoImpl;
import cn.ytc.webstore.model.Good;

@Service
public class GoodServiceImpl extends BaseService<Good> implements GoodServiceInterface{

	@Autowired
	GoodDaoImpl goodDao;
}
