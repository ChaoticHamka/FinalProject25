package by.itacademy.radzetskaya.ria.UI.pages.search;

public enum SearchLocators {

    A_TO_SEARCH_BYXPATH("//a[@data-modal-open=\"search\"]"),
    BUTTON_SEARCH_BYXPATH("//button[contains(@class, \"modal__search-submit\")]"),
    DIV_FIRST_ARTICLE_BYXPATH("//div[@class=\"list\"]//div[@class=\"list-item\"][1]//a[contains(@class,\"list-item__title\")]"),
    INPUT_SEARCH_BYXPATH("//*[@id=\"modalSearchForm\"]/input"),
    LI_RELEVANCE_BYXPATH("//div[@class=\"search-panel__filter-drop\"]/ul[@data-param=\"sort\"]/li[@data-value=\"relevance\"]"),
    DIV_SORT_BYXPATH("//div[@class=\"search-panel__block m-sort\"]//div[@class=\"search-panel__filter-button\"]");

    private final String locator;

    SearchLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
