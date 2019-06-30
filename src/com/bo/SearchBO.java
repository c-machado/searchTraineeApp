package com.bo;

import java.util.List;

import com.exception.BusinessException;
import com.model.Trainee;

public interface SearchBO {

	public Trainee getTraineeById(int id) throws BusinessException;
	public Trainee getTraineeByContact(long contact) throws BusinessException;
	public List<Trainee> getTraineesByName(String name) throws BusinessException;
	public List<Trainee> getTraineesByGender(String gender) throws BusinessException;
	public List<Trainee> getTraineesBySalary(double salary) throws BusinessException;
}
