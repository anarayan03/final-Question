package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.QuestionBean;

public interface IQuestionDao 
{
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
}
