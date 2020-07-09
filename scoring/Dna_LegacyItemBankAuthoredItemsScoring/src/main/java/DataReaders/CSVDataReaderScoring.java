package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for ViewAssessmentsFilters *****/
public class CSVDataReaderScoring {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ScoringEventData.csv";
    private String highlettext, assessmentDescription, academicYear, grade, CorrectAnswer, IncorrectAnswer, NTSecondAnswerChoice, subject, type, subjectStep2, ItemName, gradeStep2;
    private String studentID, positionOfAddedQuestion,multiPort, standardStep2, answerChoice1, SecondAnswer, AnswerForMathEquation, answerChoice3, deleteQuestion, deleteAddQuestion, positionToDeleteQuestion;
    private  String dragAndDropOrderFirstAnswer,dragAndDropOrderSecondAnswer,dragAndDropOrderThirdAnswer;
   private  String multiPortWrongAnswer;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                highlettext = readercsv.get("HighlightSelectableText");
                multiPort = readercsv.get("MultiPort");
                studentID = readercsv.get("StudentID");
                positionOfAddedQuestion = readercsv.get("PositionOfAddedQuestion");
                assessmentDescription = readercsv.get("AssessmentDescription");
                academicYear = readercsv.get("AcademicYear");
                grade = readercsv.get("Grade");
                subject = readercsv.get("Subject");
                type = readercsv.get("Type");
                subjectStep2 = readercsv.get("SubjectStep2");
                gradeStep2 = readercsv.get("GradeStep2");
                standardStep2 = readercsv.get("StandardStep2");
                answerChoice1 = readercsv.get("AnswerChoice");
                SecondAnswer = readercsv.get("SecondAnswer");
                answerChoice3 = readercsv.get("AnswerChoice3");
                deleteQuestion = readercsv.get("DeleteQuestion");
                deleteAddQuestion = readercsv.get("DeleteAddQuestion");
                positionToDeleteQuestion = readercsv.get("PositionToDeleteQuestion");
                ItemName = readercsv.get("ItemName");
                NTSecondAnswerChoice = readercsv.get("NTSecondAnswerChoice");
                CorrectAnswer = readercsv.get("CorrectAnswer");
                IncorrectAnswer = readercsv.get("IncorrectAnswer");
                AnswerForMathEquation = readercsv.get("AnswerForMathEquation");
                dragAndDropOrderFirstAnswer=readercsv.get("DragAndDropOrderFirstAnswer");
                dragAndDropOrderSecondAnswer=readercsv.get("DragAndDropOrderSecondAnswer");
                dragAndDropOrderThirdAnswer=readercsv.get("DragAndDropOrderThirdAnswer");
                multiPortWrongAnswer=readercsv.get("MultiPartWrongAnswer");

                Maprecords.put("HighlightSelectableText", highlettext);
                Maprecords.put("MultiPort", multiPort);
                Maprecords.put("StudentID", studentID);
                Maprecords.put("PositionOfAddedQuestion", positionOfAddedQuestion);
                Maprecords.put("AssessmentDescription", assessmentDescription);
                Maprecords.put("AcademicYear", academicYear);
                Maprecords.put("Grade", grade);
                Maprecords.put("Subject", subject);
                Maprecords.put("Type", type);
                Maprecords.put("SubjectStep2", subjectStep2);
                Maprecords.put("GradeStep2", gradeStep2);
                Maprecords.put("StandardStep2", standardStep2);
                Maprecords.put("AnswerChoice", answerChoice1);
                Maprecords.put("SecondAnswer", SecondAnswer);
                Maprecords.put("AnswerChoice3", answerChoice3);
                Maprecords.put("DeleteQuestion", deleteQuestion);
                Maprecords.put("DeleteAddQuestion", deleteAddQuestion);
                Maprecords.put("PositionToDeleteQuestion", positionToDeleteQuestion);
                Maprecords.put("ItemName", ItemName);
                Maprecords.put("CorrectAnswer", CorrectAnswer);
                Maprecords.put("NTSecondAnswerChoice", NTSecondAnswerChoice);
                Maprecords.put("IncorrectAnswer", IncorrectAnswer);
                Maprecords.put("AnswerForMathEquation", AnswerForMathEquation);
                Maprecords.put("DragAndDropOrderFirstAnswer", dragAndDropOrderFirstAnswer);
                Maprecords.put("DragAndDropOrderSecondAnswer", dragAndDropOrderSecondAnswer);
                Maprecords.put("DragAndDropOrderThirdAnswer", dragAndDropOrderThirdAnswer);
                Maprecords.put("MultiPartWrongAnswer", multiPortWrongAnswer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /*
    Methods to Read the Data from Csv
    */

    public String getNTSecondAnswerChoice() {
        NTSecondAnswerChoice = getCsv().get("NTSecondAnswerChoice").trim();
        return NTSecondAnswerChoice;
    }

    public String getAnswerForMathEquation() {
        AnswerForMathEquation = getCsv().get("AnswerForMathEquation").trim();
        return AnswerForMathEquation;
    }

    public String getCorrectAnswer() {
        CorrectAnswer = getCsv().get("CorrectAnswer").trim();
        return CorrectAnswer;
    }

    public String getIncorrectAnswer() {
        IncorrectAnswer = getCsv().get("IncorrectAnswer").trim();
        return IncorrectAnswer;
    }
    public String getMultiPort() {
        multiPort = getCsv().get("MultiPort").trim();
        return multiPort;
    }
    public String getMultiPortWrongAnswer() {
        multiPortWrongAnswer = getCsv().get("MultiPartWrongAnswer").trim();
        return multiPortWrongAnswer;
    }

    public String getHighlettext() {
        highlettext = getCsv().get("HighlightSelectableText").trim();
        return highlettext;
    }

    public String getStudentID() {
        studentID = getCsv().get("StudentID").trim();
        return studentID;
    }

    public String getPositionOfAddedQuestion() {
        positionOfAddedQuestion = getCsv().get("PositionOfAddedQuestion").trim();
        return positionOfAddedQuestion;
    }

    public String getAssessmentDescription() {
        assessmentDescription = getCsv().get("AssessmentDescription").trim();
        return assessmentDescription;
    }

    public String getAcademicYear() {
        academicYear = getCsv().get("AcademicYear").trim();
        return academicYear;
    }

    public String getGrade() {
        grade = getCsv().get("Grade").trim();
        return grade;
    }

    public String getSubject() {
        subject = getCsv().get("Subject").trim();
        return subject;
    }

    public String getType() {
        type = getCsv().get("Type").trim();
        return type;
    }

    public String getSubjectStep2() {
        subjectStep2 = getCsv().get("SubjectStep2").trim();
        return subjectStep2;
    }

    public String getGradeStep2() {
        gradeStep2 = getCsv().get("GradeStep2").trim();
        return gradeStep2;
    }

    public String getStandardStep2() {
        standardStep2 = getCsv().get("StandardStep2").trim();
        return standardStep2;
    }

    public String getAnswerChoice() {
        answerChoice1 = getCsv().get("AnswerChoice").trim();
        return answerChoice1;
    }

    public String getSecondAnswer() {
        SecondAnswer = getCsv().get("SecondAnswer").trim();
        return SecondAnswer;
    }

    public String getAnswerChoice3() {
        answerChoice3 = getCsv().get("AnswerChoice3").trim();
        return answerChoice3;
    }

    public String getDeleteQuestion() {
        deleteQuestion = getCsv().get("DeleteQuestion").trim();
        return deleteQuestion;
    }

    public String getDeleteAddQuestion() {
        deleteAddQuestion = getCsv().get("DeleteAddQuestion").trim();
        return deleteAddQuestion;
    }

    public String getPositionToDeleteQuestion() {
        positionToDeleteQuestion = getCsv().get("PositionToDeleteQuestion").trim();
        return positionToDeleteQuestion;
    }

    public String getItemName() {
        ItemName = getCsv().get("ItemName").trim();
        return ItemName;
    }
    public String getDragAndDropFirstAnswer() {
        dragAndDropOrderFirstAnswer = getCsv().get("DragAndDropOrderFirstAnswer").trim();
        return dragAndDropOrderFirstAnswer;
    }

    public String getDragAndDropSecondAnswer() {
        dragAndDropOrderSecondAnswer = getCsv().get("DragAndDropOrderSecondAnswer").trim();
        return dragAndDropOrderSecondAnswer;
    }
    public String getDragAndDropThirdAnswer() {
        dragAndDropOrderThirdAnswer = getCsv().get("DragAndDropOrderThirdAnswer").trim();
        return dragAndDropOrderThirdAnswer;
    }



}
