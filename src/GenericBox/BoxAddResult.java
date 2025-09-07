package GenericBox;

class BoxAddResult {
    String resultString;
    Integer resultInteger;
    Float resulttFloat;

    BoxAddResult(String resultString, Integer resultInteger) {
        this.resultString = resultString;
        this.resultInteger = resultInteger;
    }

    BoxAddResult(String resultString, Float resulttFloat) {
        this.resultString = resultString;
        this.resulttFloat = resulttFloat;
    }

    BoxAddResult(String resultString) {
        this.resultString = resultString;
    }

    BoxAddResult() {
    }

}