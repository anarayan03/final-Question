package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.QuestionBean;
import dao.CQuestionDaoImpl;
import dao.IQuestionDao;

public class QuestionServiceImpl implements IQuestionService
{

	IQuestionDao iQuestionDao = null;
	@Override
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException
	{
		iQuestionDao = new CQuestionDaoImpl();
		List<QuestionBean> list = new ArrayList<>(); 
		list = iQuestionDao.getQuestions(businessSegment);
		
		return list;
	}

}
