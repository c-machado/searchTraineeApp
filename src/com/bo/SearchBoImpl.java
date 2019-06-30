package com.bo;

import java.util.List;

import com.dao.SearchDAO;
import com.dao.SearchDaoImpl;
import com.exception.BusinessException;
import com.model.Trainee;

public class SearchBoImpl implements SearchBO {

	private SearchDAO searchDAO;

	private SearchDAO getSearchDAO(){
		if(searchDAO==null){
			searchDAO=new SearchDaoImpl();
		}
		return searchDAO;
		
	}
	
	@Override
	public Trainee getTraineeById(int id) throws BusinessException {
		Trainee trainee=null;
		if((id+"").matches("[0-9]{6}")){
			//code here for DAO layer
			trainee=getSearchDAO().getTraineeById(id);
		}else{
			throw new BusinessException("Entered trainee id "+id+" is invalid");
		}
		return trainee;
	}

	@Override
	public Trainee getTraineeByContact(long contact) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trainee> getTraineesByName(String name)
			throws BusinessException {
		List<Trainee> traineeNameList = null;
		if(name.matches("[A-Z][a-z]*")){
			traineeNameList = getSearchDAO().getTraineesByName(name);
		}
		else{
			throw new BusinessException("Entered name '"+name+"' is invalid");
		}
		return traineeNameList;
	}

	@Override
	public List<Trainee> getTraineesByGender(String gender)
			throws BusinessException {
		List<Trainee> traineeList=null;
		if(gender.matches("[mMfF]{1}")){
			//code here for DAO
			traineeList=getSearchDAO().getTraineesByGender(gender);
		}else{
			throw new BusinessException("Entered gender "+gender+" is invalid");
		}
		return traineeList;
	}

	@Override
	public List<Trainee> getTraineesBySalary(double salary)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
