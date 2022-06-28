package ru.javaops.webapp.util;
import org.junit.Assert;
import org.junit.Test;
import ru.javaops.webapp.model.Resume;
import ru.javaops.webapp.model.Section;
import ru.javaops.webapp.model.TextSection;

import static ru.javaops.webapp.storage.ResumeTestData.testDataResume1;

public class JsonParserTest {
    @Test
    public void testResume() {
        String json = JsonParser.write(testDataResume1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(testDataResume1, resume);
    }

    @Test
    public void write() {
        Section section = new TextSection("Objective");
        String json = JsonParser.write(section, Section.class);
        System.out.println(json);
        Section section1 = JsonParser.read(json, Section.class);
        Assert.assertEquals(section, section1);
    }
}
