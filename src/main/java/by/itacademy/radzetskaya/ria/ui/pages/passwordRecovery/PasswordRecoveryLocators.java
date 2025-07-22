package by.itacademy.radzetskaya.ria.ui.pages.passwordRecovery;

public enum PasswordRecoveryLocators {

    DIV_TO_RECOVERY_PASSWORD_FORM_BYXPATH("//div[@data-modal-open=\"recovery_password\"]"),
    A_TO_RECOVERY_PASSWORD_FORM_BYXPATH("//a[@data-modal-open=\"recovery_password\"]"),
    DIV_TO_AUTH_FORM_BYXPATH("//div[@id=\"modalRecoveryPassword\"]//div[@data-modal-open=\"authorization\"]"),
    DIV_RECOVERY_PASSWORD_FORM_BYID("modalRecoveryPassword"),
    DIV_AUTH_FORM_BYID("modalAuth"),
    LABEL_EMAIL_BYXPATH("//div[@id=\"modalRecoveryPassword\"]//div[contains(text(), \"Почта\")]/parent::label"),
    INPUT_EMAIL_BYID("modalRecoveryPasswordEmail"),
    DIV_RECOVERY_PASSWORD_SUBMIT_BYID("modalRecoveryPasswordSubmit"),
    BUTTON_RECOVERY_PASSWORD_SUBMIT_BYXPATH("//*[@id=\"" + DIV_RECOVERY_PASSWORD_SUBMIT_BYID.getLocator() + "\"]/button"),
    DIV_RECOVERY_PASSWORD_ERROR_BYID("modalRecoveryPasswordError");

    private final String locator;

    PasswordRecoveryLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
