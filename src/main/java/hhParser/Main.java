package hhParser;


import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationManager app = new ApplicationManager();

        app.getDriver().get("https://hh.ru/");
        app.getStartPage().goToProfessionList();

        app.getCatalogPage().selectItem("Информационные технологии");
        app.getCatalogPage().expandAll();
        app.getCatalogPage().selectItem("тестирование");

        app.getVakancyListPage().orderByDate();

        app.getVakancyListPage().setVacancyNamesList();
        List<Vacancy> vacancyes = new LinkedList<Vacancy>();

        while (app.getVakancyListPage().hasNextVacancy()) {
            app.getVakancyListPage().openNextVacancy();
            app.getWindowHelper().switchToNewWindow();
            vacancyes.add(app.getVakancyPage().getVacancy());
            app.getWindowHelper().closeСurrentWindow();
            app.getWindowHelper().switchToMainWindow();
        }

        Output output = new Output((LinkedList)vacancyes);

        output.createResultFile();

        app.stop();
    }


}

