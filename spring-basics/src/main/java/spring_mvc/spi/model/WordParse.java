package spring_mvc.spi.model;

public class WordParse implements IParseDoc {

    @Override
    public void parse() {
        System.out.println("Parse Word");
    }
}
