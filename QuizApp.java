package Special;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApp {
    static int QuestionIndex = 0;
    static int Score = 0;
    static Question[] questions;
    static Timer timer;
    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }
    static void initializeQuestions() {
        questions = new Question[5];
        questions[0] = new Question("Which one is the smallest ocean in the World?", new String[]{"Indian Ocean", "Pacific Ocean", "Atlantic Ocean", "Arctic Ocean"}, 4);
        questions[1] = new Question("Which country gifted the ‘Statue of Liberty’ to USA in 1886?", new String[]{"France", "Canada", "Brazil", "England"}, 1);
        questions[2] = new Question("In which ocean ‘Bermuda Triangle’ region is located?", new String[]{"Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"}, 1);
        questions[3] = new Question("Which country is also known as the ‘Land of Rising Sun’?", new String[]{"New Zealand", "China", "Japan", "Fiji"}, 3);
        questions[4] = new Question("Which continent has the highest number of countries?", new String[]{"Asia", "Europe", "North America", "Africa"}, 4);
    }
    static void startQuiz() {
        Scanner src = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");
        System.out.println("--------------------");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                displayNextQuestion();
            }
        }, 20000);
        displayNextQuestion();
    }
    static void displayNextQuestion() {
        if (QuestionIndex < questions.length) {
            Question currentQuestion = questions[QuestionIndex];
            System.out.println("\n" + currentQuestion.getQuestionText());
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
            }
            Scanner src = new Scanner(System.in);
            System.out.print("Select your answer (1-" + currentQuestion.getOptions().length + "): ");
            int userAnswer = src.nextInt() ;
            if (userAnswer == currentQuestion.getCorrectAnswer()) {
                Score++;
            }
            QuestionIndex++;
            timer.cancel();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    displayNextQuestion();
                }
            }, 20000);
            displayNextQuestion();
        } else {
            endQuiz();
        }
    }
    static void endQuiz() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + Score + "/" + questions.length);
        System.out.println("Thank you for playing!");
    }
}
class Question {
    private String question;
    private String[] options;
    private int correctAnswer;
    public Question(String questionText, String[] options, int correctAnswer) {
        this.question = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestionText() {
        return question;
    }
    public String[] getOptions() {
        return options;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}