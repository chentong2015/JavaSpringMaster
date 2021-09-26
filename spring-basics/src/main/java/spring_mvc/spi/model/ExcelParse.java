package spring_mvc.spi.model;

public class ExcelParse implements IParseDoc {

    @Override
    public void parse() {
        System.out.println("Parse excel");
    }
}
