package spring_web.spi;

public class ExcelParse implements IParseDoc {

    @Override
    public void parse() {
        System.out.println("Parse excel");
    }
}
