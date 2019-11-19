package hhParser;

import java.io.*;
import java.util.LinkedList;

public class Output {

    private LinkedList<Vacancy> vacancies;

    public Output(LinkedList<Vacancy> vacancies) {
        this.vacancies = (LinkedList<Vacancy>) vacancies.clone();
    }

    private File resultFile = new File("result.txt");

    public void createResultFile(){

        try {

            if (!resultFile.exists()){
                resultFile.createNewFile();
            }


        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileWriter out = new FileWriter(resultFile, false)) {

            BufferedWriter writer = new BufferedWriter(out);
            for (Vacancy vacancy: vacancies){
                writer.append(vacancy.getVacancyTitle() + '\n');
                writer.append(vacancy.getVacancyCompanyName() + '\n');
                writer.append(vacancy.getVacancyBody() + '\n');
                writer.append(vacancy.getVacancyDate() + '\n');
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
