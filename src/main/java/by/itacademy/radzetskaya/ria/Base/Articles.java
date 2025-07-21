package by.itacademy.radzetskaya.ria.Base;

import by.itacademy.radzetskaya.ria.UI.utils.LogUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Articles {

    private List<String> articles = new ArrayList<>();

    public Articles() {
        articles.add("Материнский капитал — 2025: сумма выплаты и на что ее можно потратить");
        articles.add("Производственный календарь на 2025 год: как работаем и отдыхаем");
        articles.add("ДВИ-2025: что такое и кому нужно сдавать при поступлении в вуз");
        articles.add("В Шереметьево пассажиры \"Победы\" блокировали посадку на рейс в Минводы");
        articles.add("В РЖД сообщили о задержках в связи с происшествием в Ростовской области");
        articles.add("Союзники, ставшие врагами. Как Русь обороняла южные границы от печенегов");
        articles.add("В Италии отменили концерт Гергиева");
        articles.add("В Ростехе рассказали об эффективности комплекса \"Пенициллин\"");
        articles.add("Мошенники украли у блокчейн-разработчика криптовалюту на 500 тысяч долларов");
        articles.add("\"Откройте город!\" Немцы и поляки столпились у границы с Калининградом");
    }

    public String getRandomArticleName() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(articles.size());
        String articleName = articles.get(randomNumber);
        LogUI.setArticle(articleName);
        return articleName;
    }
}
