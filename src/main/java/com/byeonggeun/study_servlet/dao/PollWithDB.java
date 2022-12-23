package com.byeonggeun.study_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
    public ArrayList<Object> getQuestion(String questionsUid) throws SQLException {

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                " WHERE QUESTIONS_UID = '" + questionsUid + "'";

        ArrayList<Object> result = new ArrayList<Object>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            HashMap<String, Object> survey = new HashMap<String, Object>();
            survey.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            survey.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            survey.put("ORDERS", resultSet.getInt("ORDERS"));
            result.add(survey);
        }
        resultSet.close();
        statement.close();
        return result;
    }
}
