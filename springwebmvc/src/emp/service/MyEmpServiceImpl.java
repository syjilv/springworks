package emp.service;

import java.util.List;

import emp.dao.MyEmpDAO;
import emp.dto.MyEmpDTO;

public class MyEmpServiceImpl implements MyEmpService {
	MyEmpDAO dao;
	
	public void setDao(MyEmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(MyEmpDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MyEmpDTO userInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public MyEmpDTO login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyEmpDTO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public List<MyEmpDTO> findByAddr(String addr) {
		return dao.findByAddr(addr);
	}

}
