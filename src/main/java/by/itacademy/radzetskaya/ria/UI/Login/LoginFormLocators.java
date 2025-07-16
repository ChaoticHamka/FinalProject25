package by.itacademy.radzetskaya.ria.UI.Login;

public enum LoginFormLocators {

    //Именование
    //  Если что-то открывает - ЧТО_(англ)TO_ЧТО_ОТКРЫВАЕТ_КАКИЩЕМ
    //  Если это веб-элемент, с которым производятся действия - ЧТО_МЕСТОНАХОЖДЕНИЕ|ОПИСАНИЕ_КАКИЩЕМ

    //кнопка открытия формы авторизации на главной странице
    BUTTON_TO_LOGIN_FORM_BYCLASS ("header__menu-left"),

    //кнопка авторизации
    BUTTON_AUTH_SUBMIT_BYXPATH ("//*[@id=\"modalAuthSubmit\"]/button"),

    //поле логина
    LABEL_EMAIL_BYXPATH("//div[@id=\"modalAuth\"]//div[contains(text(), \"Почта\")]/parent::label"),
    INPUT_EMAIL_BYID("modalAuthEmailField"),

    //поле пароля
    LABEL_PASSWORD_BYXPATH("//div[@id=\"modalAuth\"]//div[contains(text(), \"Пароль\")]/parent::label");

    private final String locator;

    LoginFormLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
