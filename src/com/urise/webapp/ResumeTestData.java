package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.*;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");

        TextSection s1 = new TextSection(OBJECTIVE,"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        TextSection s2 = new TextSection(PERSONAL,"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        TextListSection s3 = new TextListSection(ACHIEVEMENT,List.of(
            "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
            "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
            "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
            "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
            "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
            "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
            "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));
        TextListSection s4 = new TextListSection(QUALIFICATIONS,List.of(
            "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
            "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
            "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
            "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
            "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
            "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
            "Python: Django.",
            "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
            "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
            "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
            "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
            "Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
            "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
            "Родной русский, английский \"upper intermediate\""
        ));

        Participation w1 = new Participation("01/10/2013", "",
                "Автор проекта",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization o1 = new Organization("Java Online Projects", "http://javaops.ru/",List.of(w1));

        Participation w2 = new Participation("01/10/2014", "01/01/2016",
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        Organization o2 = new Organization("Wrike","https://www.wrike.com/", List.of(w2));

        Participation w3 = new Participation("01/04/2012", "01/10/2014",
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        Organization o3 = new Organization("RIT Center","", List.of(w3));

        Participation w4 = new Participation("01/12/2010", "01/04/2012",
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        Organization o4 = new Organization("Luxoft (Deutsche Bank)","http://www.luxoft.ru/", List.of(w4));

        Participation w5 = new Participation("01/06/2008", "01/12/2010",
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        Organization o5 = new Organization("Yota","https://www.yota.ru/", List.of(w5));

        Participation w6 = new Participation("01/03/2007", "01/06/2008",
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        Organization o6 = new Organization("Enkata","http://enkata.com/", List.of(w6));

        Participation w7 = new Participation("01/01/2005", "01/02/2007",
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        Organization o7 = new Organization("Siemens AG","https://www.siemens.com/ru/ru/home.html", List.of(w7));

        Participation w8 = new Participation("01/09/1997", "01/01/2005",
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Organization o8 = new Organization("Alcatel","http://www.alcatel.ru/", List.of(w8));

        ParticipationListSection s5 = new ParticipationListSection(EXPERIENCE,List.of(o1,o2,o3,o4,o5,o6,o7,o8));


        Participation e1 = new Participation("01/03/2013", "01/05/2013",
                "Functional Programming Principles in Scala' by Martin Odersky","");
        Organization oe1 = new Organization("Coursera","https://www.coursera.org/course/progfun", List.of(e1));

        Participation e2 = new Participation("01/03/2011", "01/04/2011",
                "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'","");
        Organization oe2 = new Organization("Luxoft","http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", List.of(e2));

        Participation e3 = new Participation("01/01/2005", "01/04/2005",
                "3 месяца обучения мобильным IN сетям (Берлин)","");
        Organization oe3 = new Organization("Siemens AG","http://www.siemens.ru/", List.of(e3));

        Participation e4 = new Participation("01/09/1997", "01/03/1998",
                "6 месяцев обучения цифровым телефонным сетям (Москва)","");
        Organization oe4 = new Organization("Alcatel","http://www.alcatel.ru/", List.of(e4));

        Participation e5 = new Participation("01/09/1993", "01/07/1996",
                "Аспирантура (программист С, С++)","");
        Participation e6 = new Participation("01/09/1987", "01/07/1993",
                "Инженер (программист Fortran, C)","");
        Organization oe5 = new Organization(
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/",List.of(e5,e6));

        Participation e7 = new Participation("01/09/1984", "01/06/1987",
                "Закончил с отличием","");
        Organization oe6 = new Organization("Заочная физико-техническая школа при МФТИ","http://www.school.mipt.ru/", List.of(e7));

        ParticipationListSection s6 = new ParticipationListSection(EDUCATION,List.of(oe1,oe2,oe3,oe4,oe5,oe6));

        EnumMap<SectionType, AbstractSection> sections =  new EnumMap<>(Map.of(
                s1.getType(),s1,
                s2.getType(),s2,
                s3.getType(),s3,
                s4.getType(),s4,
                s5.getType(),s5,
                s6.getType(),s6
        ));
        r.setSections(sections);

        EnumMap<ContactType, String> contacts = new EnumMap<>(Map.of(
                PHONE,"+7(921) 855-0482",
                SKYPE,"skype:grigory.kislin",
                EMAIL,"gkislin@yandex.ru",
                LINKEDIN,"https://www.linkedin.com/in/gkislin",
                GITHUB,"https://github.com/gkislin",
                STACKOVERFLOW,"https://stackoverflow.com/users/548473",
                HOMEPAGE,"https://gkislin.ru/"
        ));
        r.setContacts(contacts);

        r.print();
    }
}
