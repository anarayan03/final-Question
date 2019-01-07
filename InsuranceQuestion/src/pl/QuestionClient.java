package pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import bean.QuestionBean;
import service.IQuestionService;
import service.QuestionServiceImpl;

public class QuestionClient 
{
	
	static Scanner scanner = new Scanner(System.in);
	static IQuestionService iQuestionService = null;
	static QuestionServiceImpl questionServiceImpl = null;
	static QuestionBean questionBean = new QuestionBean();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException
	{
		String str = null ;
		int weightage = 0;
		String businessSegment;
		int i = 0;
		System.out.println(" Enter Business Segment\n");
		System.out.println("1.	Business Auto"+"\n"+"2.	Apartment"+"\n"+"3.	Restaurant"+"\n"+"4.	General Merchant"+"\n");
		int ch1 = scanner.nextInt();
		
		switch (ch1) {
		case 1 :
			
			str = "Business Auto";
			questionBean.setQuestion(str);
			break;
			
		case 2 :
			
			str = "Apartment";
			questionBean.setQuestion(str);
			break;
			
		case 3 :
			
			str = "Restaurant";
			questionBean.setQuestion(str);
			break;

		case 4 :
			
			str = "General Merchant";
			questionBean.setQuestion(str);
			break;
			
		default:
			
			System.out.println("Wrong choice");
			break;
		}
		
		QuestionBean questionBean = null;

		questionBean=new QuestionBean();
		questionServiceImpl=new QuestionServiceImpl();
		List<QuestionBean> list=new ArrayList<>();
		list=questionServiceImpl.getQuestions(str);
		
		ListIterator<QuestionBean> iterator = list.listIterator();
		try
		{
			
			if(list.isEmpty())
			{
				System.out.println("No questions....");
			}else
			{
				
				while(iterator.hasNext())
				{
					
					QuestionBean questionBean1 = new QuestionBean();
					questionBean1 = iterator.next();
					System.out.println(questionBean1.getQuestion()+"?"+"\n");
					System.out.println("1.	"+questionBean1.getAnswer1()+"\n");
					System.out.println("2.	"+questionBean1.getAnswer2()+"\n");
					System.out.println("3.	"+questionBean1.getAnswer3()+"\n");
					int choice;
					System.out.println("Select your answer\n");
					choice = scanner.nextInt();
					switch (choice)
					{
					case 1 :
						
						weightage = weightage+questionBean1.getAnswerWeightage1();
						System.out.println("\n"+weightage+"\n");
						
						break;

					case 2 :
						
						weightage = weightage+questionBean1.getAnswerWeightage2();
						System.out.println("\n"+weightage+"\n");
						
						break;
						
					case 3 :
						
						weightage = weightage+questionBean1.getAnswerWeightage3();
						System.out.println("\n"+weightage+"\n");
						
						break;
						
					default:
						
						System.out.println("\n"+"wrong answer"+"\n");
						iterator.previous();
						break;
					}
					
				}
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
