package by.itacademy.radzetskaya.ria.ui.pages.Login;

public enum LoginFormLocators {

    DIV_AUTH_CLOSE_BUTTON_BYCLASS("modal__close"),
    DIV_AUTH_SUBMIT_BYID("modalAuthSubmit"),
    BUTTON_AUTH_SUBMIT_BYXPATH("//*[@id=\"" + DIV_AUTH_SUBMIT_BYID.getLocator() + "\"]/button"),
    DIV_AUTH_ERROR_BYID("modalAuthError"),
    LABEL_EMAIL_BYXPATH("//div[@id=\"modalAuth\"]//div[contains(text(), \"Почта\")]/parent::label"),
    INPUT_EMAIL_BYID("modalAuthEmailField"),
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
