package by.itacademy.radzetskaya.ria.UI.pages.Main;

public enum MainPageLocators {

    //кнопка открытия формы авторизации на главной странице
    BUTTON_TO_LOGIN_FORM_BYCLASS("header__menu-left"),

    DIV_WITH_ARTICLES_BYCLASS("cell-reading100__list");

    private final String locator;

    MainPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
