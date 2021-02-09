package week15d02;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

    public class Quiz {

        List<Question> questions = new ArrayList<>();

        public List<Question> getQuestions() {
            return questions;
        }

        public Quiz(Path path) {

            try (BufferedReader br = Files.newBufferedReader(path)) {
                String buffer;
                String line;

                while ((line = br.readLine()) != null) {
                    buffer = br.readLine();
                    String question = line;
                    String answer = buffer.split(" ")[0];
                    int score = Integer.parseInt(buffer.split(" ")[1]);
                    String type = buffer.split(" ")[2];

                    questions.add(new Question(question, answer, score, type));

                }

            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read the file", ioe);
            }

        }

        public List<String> getQuestionBySubject(String type) {
            List<String> result = new ArrayList<>();

            for (Question i: questions) {
                if (i.getqType().equals(type)) {
                    result.add(i.getQuestion());
                }
            }

            return result;
        }

        public Question returnRandomQuestion() {

            Random rmd = new Random();
            int index = rmd.nextInt(questions.size());


            return questions.get(index);
        }

        public Map<String, List<String>> getAllQuestionsBySubject() {
            Map<String, List<String>> result = new HashMap<>();

            for (Question q: questions) {
                if (!result.containsKey(q.getqType())) {
                    result.put(q.getqType(), new ArrayList<>());
                }
                result.get(q.getqType()).add(q.getQuestion());
            }

            return result;
        }

        private Map<String, Integer> getScoreBySubject() {
            Map<String, Integer> temp = new HashMap<>();

            for (Question q: questions) {
                if (!temp.containsKey(q.getqType())) {
                    temp.put(q.getqType(), 0);
                }
                temp.put(q.getqType(), temp.get(q.getqType()) + q.getScore());
            }

            return temp;
        }

        public String getHighScoreBySubject() {

            Map<String, Integer> temp2 = this.getScoreBySubject();
            int max = 0;
            Map.Entry<String, Integer> temp3 = null;

            for (Map.Entry<String, Integer> m: temp2.entrySet()) {
                if (max<m.getValue()) {
                    max = m.getValue();
                    temp3 = m;
                }
            }

            return temp3.getKey();
        }

        public static void main(String[] args) {

            Path path = Path.of("kerdesek.txt");

            Quiz quiz = new Quiz(path);
            //System.out.println(quiz.questions.size());
            //System.out.println(quiz.getQuestionBySubject("tortenelem").size());
            //System.out.println(quiz.returnRandomQuestion());
            //System.out.println(quiz.getAllQuestionsBySubject());
            //System.out.println(quiz.getScoreBySubject());
            System.out.println(quiz.getHighScoreBySubject());


        }
    }