package guru.qa.niffler.test.pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HistoryBlock {
    private final SelenideElement spendingTable = $(".spendings-table tbody");
    private final SelenideElement deleteSelectedButton = $(byText("Delete selected"));
    private final ElementsCollection rows = spendingTable.$$("tr");

    public SelenideElement getCell(Integer nRow, Columns column){
        SelenideElement row = rows.get(nRow);
        switch (column){
            case CHECKBOX -> {
                return row
                        .$("td:nth-child(1)").$("input")
                        .scrollIntoView(true);
            }
        }
        return null;
    }

    @Step("Check that spending was deleted")
    public void checkRowsSize(int expectedSize){
        rows.shouldHave(size(expectedSize));
    }

    public void clickOnDeleteButton() {
        deleteSelectedButton.click();
    }
}
