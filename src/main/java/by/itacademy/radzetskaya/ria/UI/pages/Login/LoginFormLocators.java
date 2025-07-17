package by.itacademy.radzetskaya.ria.UI.pages.Login;

public enum LoginFormLocators {

    //Именование
    //  Если что-то открывает - ЧТО_(англ)TO_ЧТО_ОТКРЫВАЕТ_КАКИЩЕМ
    //  Если это веб-элемент, с которым производятся действия - ЧТО_МЕСТОНАХОЖДЕНИЕ|ОПИСАНИЕ_КАКИЩЕМ

    //кнопка открытия формы авторизации на главной странице
    BUTTON_TO_LOGIN_FORM_BYCLASS ("header__menu-left"),

    //кнопка авторизации
    DIV_AUTH_SUBMIT_BYID ("modalAuthSubmit"),
    BUTTON_AUTH_SUBMIT_BYXPATH ("//*[@id=\""+ DIV_AUTH_SUBMIT_BYID.getLocator() +"\"]/button"),
    DIV_AUTH_ERROR_BYID("modalAuthError"),

    //поле логина
    LABEL_EMAIL_BYXPATH("//div[@id=\"modalAuth\"]//div[contains(text(), \"Почта\")]/parent::label"),
    INPUT_EMAIL_BYID("modalAuthEmailField"),

    //поле пароля
    LABEL_PASSWORD_BYXPATH("//div[@id=\"modalAuth\"]//div[contains(text(), \"Пароль\")]/parent::label"),
    INPUT_PASSWORD_BYID("modalAuthPassword");

    private final String locator;

    LoginFormLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
