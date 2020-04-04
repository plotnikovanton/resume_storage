package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.*;
import ru.javaops.webapp.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;

public class ResumeTestData {

    public static Resume testDataResume1 = new Resume("uuid1", "Full Name");
    public static Resume testDataResume2 = new Resume("uuid2", "Full Name");
    public static Resume testDataResume3 = new Resume("uuid3", "Full Name");
    public static Resume testDataResume4 = new Resume("uuid4", "Full Name");

    static {

        testDataResume1.setContact(ContactType.PHONENUMBER, "+7(921) 855-0482");
        testDataResume1.setContact(ContactType.SKYPE, "grigory.kislin");
        testDataResume1.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        testDataResume1.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        testDataResume1.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        testDataResume1.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        testDataResume1.setContact(ContactType.WEBPAGE, "http://gkislin.ru/");

        testDataResume1.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения" +
                " по Java Web и Enterprise технологиям"));

        testDataResume1.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));

        ListSection achievements1 = new ListSection();
        achievements1.setItem("С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). " +
                "Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements1.setItem("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements1.setItem("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievements1.setItem("Реализация c нуля Rich Internet Application приложения на стеке технологий " +
                "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements1.setItem("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements1.setItem("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        testDataResume1.setSection(SectionType.ACHIEVEMENT, achievements1);

        ListSection qualifications1 = new ListSection();
        qualifications1.setItem("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications1.setItem("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications1.setItem("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualifications1.setItem("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications1.setItem("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications1.setItem("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications1.setItem("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring " +
                "(MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), " +
                "Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications1.setItem("Python: Django.");
        qualifications1.setItem("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications1.setItem("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications1.setItem("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, " +
                "SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, " +
                "LDAP, OAuth1, OAuth2, JWT.");
        qualifications1.setItem("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications1.setItem("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, " +
                "Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualifications1.setItem("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        qualifications1.setItem("Родной русский, английский \"upper intermediate\"");
        testDataResume1.setSection(SectionType.QUALIFICATIONS, qualifications1);

        Organization jop = new Organization("Java Online Projects", "http://javaops.ru/",
                new Period(DateUtil.of(2013, Month.OCTOBER),
                        LocalDate.now(),
                        "Автор проекта",
                        "Создание, организация и проведение Java онлайн проектов и стажировок."));

        Organization wrike = new Organization("Wrike",
                "https://www.wrike.com/",
                new Period(DateUtil.of(2014, Month.OCTOBER), DateUtil.of(2016, Month.JANUARY),
                        "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы " +
                        "управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));

        Organization ritCenter = new Organization("RIT Center",
                "https://www.rit.edu/",
                new Period(DateUtil.of(2012, Month.APRIL), DateUtil.of(2014, Month.OCTOBER),
                        "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: " +
                        "релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                        "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                        "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                        "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                        "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, " +
                        "Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));

        Organization luxoft = new Organization("Luxoft (Deuche Bank)", "http://www.luxoft.ru/",
                new Period(DateUtil.of(2010, Month.DECEMBER),
                        DateUtil.of(2012, Month.APRIL),
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, " +
                                "SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                                "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), " +
                                "Highstock, Commet, HTML5."));

        Organization yota = new Organization("Yota", "https://www.yota.ru/",
                new Period(DateUtil.of(2008, Month.JUNE),
                        DateUtil.of(2010, Month.DECEMBER),
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                                "Реализация администрирования, статистики и мониторинга фреймворка. " +
                                "Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));

        Organization enkata = new Organization("Enkata", "http://enkata.com/",
                new Period(DateUtil.of(2007, Month.FEBRUARY),
                        DateUtil.of(2008, Month.JUNE),
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной " +
                                "(JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));

        Organization siemens = new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html",
                new Period(DateUtil.of(2995, Month.JANUARY),
                        DateUtil.of(2007, Month.FEBRUARY),
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, " +
                                "реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));

        Organization alcatel = new Organization("Alcatel", "http://www.alcatel.ru/",
                new Period(DateUtil.of(1997, Month.SEPTEMBER),
                        DateUtil.of(2005, Month.JANUARY),
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции " +
                                "Alcatel 1000 S12 (CHILL, ASM)."));

        ExperienceSection workExperience = new ExperienceSection();
        workExperience.setOrganizations(jop);
        workExperience.setOrganizations(wrike);
        workExperience.setOrganizations(ritCenter);
        workExperience.setOrganizations(luxoft);
        workExperience.setOrganizations(yota);
        workExperience.setOrganizations(enkata);
        workExperience.setOrganizations(siemens);

        testDataResume1.setSection(SectionType.EXPERIENCE, workExperience);

        Organization coursera = new Organization("Coursera", "https://www.coursera.org/course/progfun",
                new Period(DateUtil.of(2013, Month.MARCH),
                        DateUtil.of(2013, Month.MAY),
                        "Учащийся",
                        "\"Functional Programming Principles in Scala\" by Martin Odersky"));

        Organization luxoftStudy = new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                new Period(DateUtil.of(2011, Month.MARCH),
                        DateUtil.of(2011, Month.APRIL),
                        "Учащийся",
                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));

        Organization siemensStudy = new Organization("Siemens AG", "http://www.siemens.ru/",
                new Period(DateUtil.of(2005, Month.JANUARY),
                        DateUtil.of(2005, Month.APRIL),
                        "Учащийся",
                        "3 месяца обучения мобильным IN сетям (Берлин)"));

        Organization alcatelStudy = new Organization("Alcatel", "http://www.alcatel.ru/",
                new Period(DateUtil.of(1997, Month.SEPTEMBER),
                        DateUtil.of(1998, Month.MARCH),
                        "Учащийся",
                        "6 месяцев обучения цифровым телефонным сетям (Москва)"));

        Organization itmo = new Organization("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики",
                "http://www.ifmo.ru/",
                new Period(
                        DateUtil.of(1993, Month.SEPTEMBER), DateUtil.of(1996, Month.JULY),
                        "Учащийся", "Аспирантура (программист С, С++)"),
                new Period(DateUtil.of(1987, Month.SEPTEMBER),
                        DateUtil.of(1993, Month.JULY),
                        "Учащийся",
                        "Инженер (программист Fortran, C)"));

        Organization mfti = new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                new Period(DateUtil.of(1984, Month.SEPTEMBER),
                        DateUtil.of(1987, Month.JUNE),
                        "Учащийся",
                        "Закончил с отличием"));

        ExperienceSection studyExperience = new ExperienceSection();
        studyExperience.setOrganizations(coursera);
        studyExperience.setOrganizations(luxoftStudy);
        studyExperience.setOrganizations(siemensStudy);
        studyExperience.setOrganizations(alcatelStudy);
        studyExperience.setOrganizations(itmo);
        studyExperience.setOrganizations(mfti);

        testDataResume1.setSection(SectionType.EDUCATION, studyExperience);
    }

    public static void main(String[] args) {
        System.out.println(testDataResume1);
    }
}
