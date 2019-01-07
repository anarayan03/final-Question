package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.QuestionBean;
import util.DbConnection;

public class CQuestionDaoImpl implements IQuestionDao
{

	@Override
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException
	{
		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
		
		try
		{
			preparedStatement = connection.prepareStatement(QueryMapper.EXECUTE_QUERY);
			preparedStatement.setString(1, businessSegment);
			resultSet = preparedStatement.executeQuery();
			List<QuestionBean> list = new ArrayList<>();
			Iterator<QuestionBean> iterator = list.iterator();
			while(resultSet.next())
			{
				QuestionBean questionBean = new QuestionBean();
				questionBean.setQuestionId(resultSet.getString(1));
				questionBean.setBusinessSegment(resultSet.getString(2));
				questionBean.setQuestionNo(resultSet.getInt(3));
				questionBean.setQuestion(resultSet.getString(4));
				questionBean.setAnswer1(resultSet.getString(5));
				questionBean.setAnswerWeightage1(resultSet.getInt(6));
				questionBean.setAnswer2(resultSet.getString(7));
				questionBean.setAnswerWeightage2(resultSet.getInt(8));
				questionBean.setAnswer3(resultSet.getString(9));
				questionBean.setAnswerWeightage3(resultSet.getInt(10));
				
				/*System.out.println(questionBean.getQuestionId()+"	"+questionBean.getBusinessSegment()+"	"
						+questionBean.getQuestionNo()+"	"+questionBean.getQuestion()+"	"
						+questionBean.getAnswer1()+"	"+questionBean.getAnswerWeightage1()+"	"
						+questionBean.getAnswer2()+"	"+questionBean.getAnswerWeightage2()+"	"
						+questionBean.getAnswer3()+"	"+questionBean.getAnswerWeightage3()+"	");*/
				
				list.add(questionBean);
			}
			
			return list;
		}catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return null;
	}

}
