package spring_web.spi;

public class WordParse implements IParseDoc {

    @Override
    public void parse() {
        System.out.println("Parse Word");
    }
}
