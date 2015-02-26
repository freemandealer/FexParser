package com.freeman.fexparser.parser.markdown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.freeman.fexparser.parser.markdown.Configuration.Builder;


public class Markdown4jProcessor {

    private Builder      builder;

    private ExtDecorator decorator;

    public Markdown4jProcessor() {
        this.builder = builder();
    }

    private Builder builder() {
        decorator = new ExtDecorator();
        return Configuration.builder().forceExtentedProfile()
            .registerPlugins(new YumlPlugin(), new WebSequencePlugin(), new IncludePlugin())
            .convertNewline2Br().setDecorator(decorator)
            .setCodeBlockEmitter(new CodeBlockEmitter());
    }

    public Markdown4jProcessor registerPlugins(Plugin... plugins) {
        builder.registerPlugins(plugins);
        return this;
    }

    public Markdown4jProcessor setDecorator(ExtDecorator decorator) {
        this.decorator = decorator;
        builder.setDecorator(decorator);
        return this;
    }

    public Markdown4jProcessor addHtmlAttribute(String name, String value, String... tags) {
        decorator.addHtmlAttribute(name, value, tags);
        return this;
    }

    public Markdown4jProcessor addStyleClass(String styleClass, String... tags) {
        decorator.addStyleClass(styleClass, tags);
        return this;
    }

    public String process(File file) throws IOException {
        return Processor.process(file, builder.build());
    }

    public String process(InputStream input) throws IOException {
        return Processor.process(input);
    }

    public String process(Reader reader) throws IOException {
        return Processor.process(reader, builder.build());
    }

    public String process(String input) throws IOException {
        return Processor.process(input, builder.build());
    }

    public static Markdown4jProcessor getProcessor() {
        return new Markdown4jProcessor().registerPlugins(new MyTablePlugin()).registerPlugins(
            new MyCodePlugin());
    }
}
