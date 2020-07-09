package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for ViewAssessmentsFilters *****/
public class CSVDataReaderItemBankAssessment {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ItemBankAssessmentTestData.csv";
    private String numberOfQuestions, assessmentDescription, academicYear, grade, CorrectAnswer, IncorrectAnswer, NTSecondAnswerChoice, subject, type, subjectStep2, ItemName, gradeStep2;
    private String studentID, positionOfAddedQuestion, standardStep2, eSRAnswerChoice, eSRSecondAnswerChoice, answerChoice1, SecondAnswer, AnswerForMathEquation, answerChoice3, deleteQuestion, deleteAddQuestion, positionToDeleteQuestion;
    private String eBSRItemName, hSTItemName, multiPortItemName, dragAndDropClassifyItemName, dragAndDropOrderItemName;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                numberOfQuestions = readercsv.get("NumberOfQuestions");
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
                eBSRItemName = readercsv.get("EBSRItemName");
                hSTItemName = readercsv.get("HSTItemName");
                multiPortItemName = readercsv.get("MultiPortItemName");
                dragAndDropClassifyItemName = readercsv.get("DragAnsDropClassifyItemName");
                dragAndDropOrderItemName = readercsv.get("DragAndDropOrderItemName");
                eSRAnswerChoice = readercsv.get("ESRAnswerChoice");
                eSRSecondAnswerChoice = readercsv.get("ESRSecondAnswerChoice");


                Maprecords.put("NumberOfQuestions", numberOfQuestions);
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
                Maprecords.put("ESRAnswerChoice", eSRAnswerChoice);
                Maprecords.put("ESRSecondAnswerChoice", eSRSecondAnswerChoice);

                Maprecords.put("EBSRItemName", eBSRItemName);
                Maprecords.put("HSTItemName", hSTItemName);
                Maprecords.put("MultiPortItemName", multiPortItemName);
                Maprecords.put("DragAnsDropClassifyItemName", dragAndDropClassifyItemName);
                Maprecords.put("DragAndDropOrderItemName", dragAndDropOrderItemName);


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

    public String geteBSRItemName() {
        eBSRItemName = getCsv().get("EBSRItemName").trim();
        return eBSRItemName;
    }

    public String gethSTItemName() {
        hSTItemName = getCsv().get("HSTItemName").trim();
        return hSTItemName;
    }

    public String getMultiPortItemName() {
        multiPortItemName = getCsv().get("MultiPortItemName").trim();
        return multiPortItemName;
    }

    public String getDragAndDropClassifyItemName() {
        dragAndDropClassifyItemName = getCsv().get("DragAnsDropClassifyItemName").trim();
        return dragAndDropClassifyItemName;
    }

    public String getDragAndDropOrderItemName() {
        dragAndDropOrderItemName = getCsv().get("DragAndDropOrderItemName").trim();
        return dragAndDropOrderItemName;
    }

    public String getCorrectAnswer() {
        CorrectAnswer = getCsv().get("CorrectAnswer").trim();
        return CorrectAnswer;
    }

    public String getIncorrectAnswer() {
        IncorrectAnswer = getCsv().get("IncorrectAnswer").trim();
        return IncorrectAnswer;
    }

    public String getESRAnswerChoice() {
        eSRAnswerChoice = getCsv().get("ESRAnswerChoice").trim();
        return eSRAnswerChoice;
    }

    public String getESRSecondAnswerChoice() {
        eSRSecondAnswerChoice = getCsv().get("ESRSecondAnswerChoice").trim();
        return eSRSecondAnswerChoice;
    }

    public String getNumberOfQuestions() {
        numberOfQuestions = getCsv().get("NumberOfQuestions").trim();
        return numberOfQuestions;
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


}
