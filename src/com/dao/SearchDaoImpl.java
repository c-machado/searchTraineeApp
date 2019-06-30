package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.MySQLConnection;
import com.exception.BusinessException;
import com.model.Trainee;

public class SearchDaoImpl implements SearchDAO {

	@Override
	public Trainee getTraineeById(int id) throws BusinessException {

		Trainee trainee=null;
		try(Connection connection=MySQLConnection.getConnection()){
			String sql="select name,contact,gender,salary from trainee1 where id=?";
			System.out.println("trainee found with id en DAO "+sql);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				trainee=new Trainee();
				trainee.setId(id);
				trainee.setName(resultSet.getString("name"));
				trainee.setSalary(resultSet.getDouble("salary"));
				trainee.setGender(resultSet.getString("gender"));
				trainee.setContact(resultSet.getLong("contact"));
			}else{
				throw new BusinessException("No trainee found with id "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error...");
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
		List<Trainee> traineeNameList = new ArrayList<>();
		try(Connection connection = MySQLConnection.getConnection()){
			String sql = "select id,name,contact,salary,gender from trainee1 where name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				Trainee trainee = new Trainee();
				trainee.setId(resultSet.getInt("id"));
				trainee.setName(name);
				trainee.setSalary(resultSet.getDouble("salary"));
				trainee.setContact(resultSet.getLong("contact"));
				trainee.setGender(resultSet.getString("gender"));
				traineeNameList.add(trainee);
			}
			if(traineeNameList.size()==0){
				throw new BusinessException("No trainee founded with the name "+name);
			}
		}catch (SQLException | ClassNotFoundException e ){
			throw new BusinessException("Internal error "+e);
		}
		return traineeNameList;
	}

	@Override
	public List<Trainee> getTraineesByGender(String gender)
			throws BusinessException {
		List<Trainee> traineeList=new ArrayList<>();
		try(Connection connection=MySQLConnection.getConnection()){
			String sql="select id,name,contact,salary from trainee1 where gender=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Trainee trainee=new Trainee();
				trainee.setId(resultSet.getInt("id"));
				trainee.setName(resultSet.getString("name"));
				trainee.setSalary(resultSet.getDouble("salary"));
				trainee.setGender(gender);
				trainee.setContact(resultSet.getLong("contact"));
				traineeList.add(trainee);
			}
			
			if(traineeList.size()==0){
				throw new BusinessException("No trainee found with gender "+gender);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error...");
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
