package ru.javaops.webapp;

import ru.javaops.webapp.model.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class ResumeTestData {
    public static void main(String[] args) throws MalformedURLException {
        Resume resume = new Resume("Григорий Кислин");

        resume.setContacts(ContactType.PHONENUMBER, "+7(921) 855-0482");
        resume.setContacts(ContactType.SKYPE, "grigory.kislin");
        resume.setContacts(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContacts(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContacts(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContacts(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.setContacts(ContactType.WEBPAGE, "http://gkislin.ru/");

        resume.setSections(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения" +
                " по Java Web и Enterprise технологиям"));

        resume.setSections(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));

        ListSection achievements = new ListSection();
        achievements.setItem("С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). " +
                "Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.setItem("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.setItem("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievements.setItem("Реализация c нуля Rich Internet Application приложения на стеке технологий " +
                "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.setItem("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.setItem("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        resume.setSections(SectionType.ACHIEVEMENT, achievements);

        ListSection qualifications = new ListSection();
        qualifications.setItem("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.setItem("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.setItem("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualifications.setItem("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.setItem("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications.setItem("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.setItem("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring " +
                "(MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), " +
                "Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.setItem("Python: Django.");
        qualifications.setItem("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.setItem("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.setItem("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, " +
                "SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, " +
                "LDAP, OAuth1, OAuth2, JWT.");
        qualifications.setItem("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.setItem("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, " +
                "Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualifications.setItem("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        qualifications.setItem("Родной русский, английский \"upper intermediate\"");
        resume.setSections(SectionType.QUALIFICATIONS, qualifications);

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MM/yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();

        Organization jop = new Organization("Java Online Projects");
        jop.setLink(new URL("http://javaops.ru/"));
        jop.setDateOfEntering(LocalDate.parse("10/2013", formatter));
        jop.setDateOfLeaving(LocalDate.now());
        jop.setPosition("Автор проекта");
        jop.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");

        Organization wrike = new Organization("Wrike");
        wrike.setLink(new URL("https://www.wrike.com/"));
        wrike.setDateOfEntering(LocalDate.parse("10/2014", formatter));
        wrike.setDateOfLeaving(LocalDate.parse("01/2016", formatter));
        wrike.setPosition("Старший разработчик (backend)");
        wrike.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");

        Organization ritCenter = new Organization("RIT Center");
        ritCenter.setDateOfEntering(LocalDate.parse("04/2012", formatter));
        ritCenter.setDateOfLeaving(LocalDate.parse("10/2014", formatter));
        ritCenter.setPosition("Java архитектор");
        ritCenter.setDescription("Организация процесса разработки системы ERP для разных окружений: " +
                "релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, " +
                "Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");

        Organization luxoft = new Organization("Luxoft (Deuche Bank)");
        luxoft.setLink(new URL("http://www.luxoft.ru/"));
        luxoft.setDateOfEntering(LocalDate.parse("12/2010", formatter));
        luxoft.setDateOfLeaving(LocalDate.parse("04/2012", formatter));
        luxoft.setPosition("Ведущий программист");
        luxoft.setDescription("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, " +
                "SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), " +
                "Highstock, Commet, HTML5.");

        Organization yota = new Organization("Yota");
        yota.setLink(new URL("https://www.yota.ru/"));
        yota.setDateOfEntering(LocalDate.parse("06/2008", formatter));
        yota.setDateOfLeaving(LocalDate.parse("12/2010", formatter));
        yota.setPosition("Ведущий специалист");
        yota.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. " +
                "Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");

        Organization enkata = new Organization("Enkata");
        enkata.setLink(new URL("http://enkata.com/"));
        enkata.setDateOfEntering(LocalDate.parse("02/2007", formatter));
        enkata.setDateOfLeaving(LocalDate.parse("06/2008", formatter));
        enkata.setPosition("Разработчик ПО");
        enkata.setDescription("Реализация клиентской (Eclipse RCP) и серверной " +
                "(JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");

        Organization siemens = new Organization("Siemens AG");
        siemens.setLink(new URL("https://www.siemens.com/ru/ru/home.html"));
        siemens.setDateOfEntering(LocalDate.parse("01/2005", formatter));
        siemens.setDateOfLeaving(LocalDate.parse("02/2007", formatter));
        siemens.setPosition("Разработчик ПО");
        siemens.setDescription("Разработка информационной модели, проектирование интерфейсов, " +
                "реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");

        Organization alcatel = new Organization("Alcatel");
        alcatel.setLink(new URL("http://www.alcatel.ru/"));
        alcatel.setDateOfEntering(LocalDate.parse("09/1997", formatter));
        alcatel.setDateOfLeaving(LocalDate.parse("01/2005", formatter));
        alcatel.setPosition("Инженер по аппаратному и программному тестированию");
        alcatel.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции " +
                "Alcatel 1000 S12 (CHILL, ASM).");

        ExperienceSection workExperience = new ExperienceSection();
        workExperience.setOrganizations(jop);
        workExperience.setOrganizations(wrike);
        workExperience.setOrganizations(ritCenter);
        workExperience.setOrganizations(luxoft);
        workExperience.setOrganizations(yota);
        workExperience.setOrganizations(enkata);
        workExperience.setOrganizations(siemens);

        resume.setSections(SectionType.EXPERIENCE, workExperience);

        Organization coursera = new Organization("Coursera");
        coursera.setLink(new URL("https://www.coursera.org/course/progfun"));
        coursera.setDateOfEntering(LocalDate.parse("03/2013", formatter));
        coursera.setDateOfLeaving(LocalDate.parse("05/2013", formatter));
        coursera.setDescription("\"Functional Programming Principles in Scala\" by Martin Odersky");

        Organization luxoftStudy = new Organization("Luxoft");
        luxoftStudy.setLink(new URL("http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"));
        luxoftStudy.setDateOfEntering(LocalDate.parse("03/2011", formatter));
        luxoftStudy.setDateOfLeaving(LocalDate.parse("04/2011", formatter));
        luxoftStudy.setDescription("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");

        Organization siemensStudy = new Organization("Siemens AG");
        siemensStudy.setLink(new URL("http://www.siemens.ru/"));
        siemensStudy.setDateOfEntering(LocalDate.parse("01/2005", formatter));
        siemensStudy.setDateOfLeaving(LocalDate.parse("04/2005", formatter));
        siemensStudy.setDescription("3 месяца обучения мобильным IN сетям (Берлин)");

        Organization alcatelStudy = new Organization("Alcatel");
        alcatelStudy.setLink(new URL("http://www.alcatel.ru/"));
        alcatelStudy.setDateOfEntering(LocalDate.parse("09/1997", formatter));
        alcatelStudy.setDateOfLeaving(LocalDate.parse("03/1998", formatter));
        alcatelStudy.setDescription("6 месяцев обучения цифровым телефонным сетям (Москва)");

        Organization itmoAsp = new Organization("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики");
        itmoAsp.setLink(new URL("http://www.ifmo.ru/"));
        itmoAsp.setDateOfEntering(LocalDate.parse("09/1993", formatter));
        itmoAsp.setDateOfLeaving(LocalDate.parse("07/1996", formatter));
        itmoAsp.setDescription("Аспирантура (программист С, С++)");

        Organization itmoEng = new Organization("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики");
        itmoEng.setLink(new URL("http://www.ifmo.ru/"));
        itmoEng.setDateOfEntering(LocalDate.parse("09/1987", formatter));
        itmoEng.setDateOfLeaving(LocalDate.parse("07/1993", formatter));
        itmoEng.setDescription("Инженер (программист Fortran, C)");

        Organization mfti = new Organization("Заочная физико-техническая школа при МФТИ");
        mfti.setLink(new URL("http://www.school.mipt.ru/"));
        mfti.setDateOfEntering(LocalDate.parse("09/1984", formatter));
        mfti.setDateOfLeaving(LocalDate.parse("06/1987", formatter));
        mfti.setDescription("Закончил с отличием");

        ExperienceSection studyExperience = new ExperienceSection();
        studyExperience.setOrganizations(coursera);
        studyExperience.setOrganizations(luxoftStudy);
        studyExperience.setOrganizations(siemensStudy);
        studyExperience.setOrganizations(alcatelStudy);
        studyExperience.setOrganizations(itmoAsp);
        studyExperience.setOrganizations(itmoEng);
        studyExperience.setOrganizations(mfti);

        resume.setSections(SectionType.EDUCATION, studyExperience);

        System.out.println(resume);
    }
}
