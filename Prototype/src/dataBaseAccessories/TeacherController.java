package dataBaseAccessories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import resources.Question;

public class TeacherController {
	private Connection connection;

	public TeacherController() {
		connection = MysqlConnection.connection(); /* get the defined server connection */
	}

	/* returns the whole table of questions for the table view*/
	public ObservableList<Question> getQuestions() throws SQLException {
		ObservableList<Question> questions = FXCollections.observableArrayList();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Questions;");
		while (rs.next()) {
			questions.add(
					new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		return questions;
	}

	/* returns the selected question details (if exists) */
	public String requestedQuestion(String questionID) throws SQLException {
		Statement statement = connection.createStatement();
		String question = "There's no such question with the requested ID";
		ResultSet rs = statement.executeQuery("SELECT * FROM Questions;");
		while (rs.next()) {
			/* if the question exists */
			if (rs.getString(1).equals(questionID)) {
				question = "Your Question Details:\nID: " + rs.getString(1) + "\nAuthor: " + rs.getString(2)
						+ "\nText: " + rs.getString(3) + "\nPossible Answers: " + rs.getString(4) + "\nCorrect Answer: "
						+ rs.getString(5);
				break;
			}
		}
		rs.close();
		return question;
	}

	/*
	 * currently changes only the correct answer field in the DB but will be
	 * expanded to whole question
	 */
	public boolean editQuestion(String questionID, String newCorrectAnswer) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Questions;");
		while (rs.next()) {
			/* if the question exists */
			if (rs.getString(1).equals(questionID)) {
				/* if the new correct answer is the same as the old one */
				if (rs.getString(5).equals(newCorrectAnswer)) {
					System.out.println("This is the same answer");
					rs.close();
					return false;
				}
				/* if the new answer is not one of the options */
				else if (!rs.getString(4).contains(newCorrectAnswer)) {
					System.out.println("The new answer is not one of the given options");
					rs.close();
					return false;
				} else {
					statement.executeUpdate("UPDATE Questions SET correctAnswer='" + newCorrectAnswer
							+ "' WHERE questionID='" + questionID + "';");
					rs.close();
					return true;
				}
			}
		}
		rs.close();
		System.out.println("The question doesn't exist");
		return false;
	}
}