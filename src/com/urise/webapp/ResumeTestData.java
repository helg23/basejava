package com.urise.webapp;

import com.urise.webapp.model.*;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static com.urise.webapp.model.Resume.ContactType.*;
import static com.urise.webapp.model.Resume.SectionType.*;
import static java.lang.Math.abs;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");

        TextSection s1 = new TextSection(OBJECTIVE.getTitle(), "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        TextSection s2 = new TextSection(PERSONAL.getTitle(), "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        TextListSection s3 = new TextListSection(ACHIEVEMENT.getTitle(), List.of(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));
        TextListSection s4 = new TextListSection(QUALIFICATIONS.getTitle(), List.of(
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

        Position w1 = new Position(LocalDate.of(2013,10,01), null,
                "Автор проекта",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization o1 = new Organization("Java Online Projects", "http://javaops.ru/", List.of(w1));

        Position w2 = new Position(
                LocalDate.of(2014,10,1),
                LocalDate.of(2016,1,1),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        Organization o2 = new Organization("Wrike", "https://www.wrike.com/", List.of(w2));

        Position w3 = new Position(
                LocalDate.of(2012,4,1),
                LocalDate.of(2014,10,1),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        Organization o3 = new Organization("RIT Center", "", List.of(w3));

        Position w4 = new Position(
                LocalDate.of(2010,12,1),
                LocalDate.of(2012,4,1),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        Organization o4 = new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", List.of(w4));

        Position w5 = new Position(
                LocalDate.of(2008,1,6),
                LocalDate.of(2018,12,1),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        Organization o5 = new Organization("Yota", "https://www.yota.ru/", List.of(w5));

        Position w6 = new Position(
                LocalDate.of(2007,3,1),
                LocalDate.of(2008,6,1),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        Organization o6 = new Organization("Enkata", "http://enkata.com/", List.of(w6));

        Position w7 = new Position(
                LocalDate.of(2005,1,1),
                LocalDate.of(2007,2,1),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        Organization o7 = new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html", List.of(w7));

        Position w8 = new Position(
                LocalDate.of(1997,9,1),
                LocalDate.of(2005,1,1),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Organization o8 = new Organization("Alcatel", "http://www.alcatel.ru/", List.of(w8));

        OrganizationListSection s5 = new OrganizationListSection(EXPERIENCE.getTitle(), List.of(o1, o2, o3, o4, o5, o6, o7, o8));


        Position e1 = new Position(
                LocalDate.of(2013,3,1),
                LocalDate.of(2013,5,1),
                "Functional Programming Principles in Scala' by Martin Odersky", null);
        Organization oe1 = new Organization("Coursera", "https://www.coursera.org/course/progfun", List.of(e1));

        Position e2 = new Position(
                LocalDate.of(2011,3,1),
                LocalDate.of(2011,4,1),
                "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", null);
        Organization oe2 = new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", List.of(e2));

        Position e3 = new Position(
                LocalDate.of(2005,1,1),
                LocalDate.of(2005,4,1),
                "3 месяца обучения мобильным IN сетям (Берлин)", null);
        Organization oe3 = new Organization("Siemens AG", "http://www.siemens.ru/", List.of(e3));

        Position e4 = new Position(
                LocalDate.of(1997,9,1),
                LocalDate.of(1998,3,1),
                "6 месяцев обучения цифровым телефонным сетям (Москва)", null);
        Organization oe4 = new Organization("Alcatel", "http://www.alcatel.ru/", List.of(e4));

        Position e5 = new Position(
                LocalDate.of(1993,9,1),
                LocalDate.of(1996,7,1),
                "Аспирантура (программист С, С++)", null);
        Position e6 = new Position(
                LocalDate.of(1987,9,1),
                LocalDate.of(1993,7,1),
                "Инженер (программист Fortran, C)", null);
        Organization oe5 = new Organization(
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/", List.of(e5, e6));

        Position e7 = new Position(
                LocalDate.of(1984,9,1),
                LocalDate.of(1987,6,1),
                "Закончил с отличием", "");
        Organization oe6 = new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", List.of(e7));

        OrganizationListSection s6 = new OrganizationListSection(EDUCATION.getTitle(), List.of(oe1, oe2, oe3, oe4, oe5, oe6));

        EnumMap<Resume.SectionType, AbstractSection> sections = new EnumMap<>(Map.of(
                OBJECTIVE, s1,
                PERSONAL, s2,
                ACHIEVEMENT, s3,
                QUALIFICATIONS, s4,
                EXPERIENCE, s5,
                EDUCATION, s6
        ));
        r.setSections(sections);

        EnumMap<Resume.ContactType, String> contacts = new EnumMap<>(Map.of(
                PHONE, "+7(921) 855-0482",
                SKYPE, "skype:grigory.kislin",
                EMAIL, "gkislin@yandex.ru",
                LINKEDIN, "https://www.linkedin.com/in/gkislin",
                GITHUB, "https://github.com/gkislin",
                STACKOVERFLOW, "https://stackoverflow.com/users/548473",
                HOMEPAGE, "https://gkislin.ru/"
        ));
        r.setContacts(contacts);

        System.out.println(r);
    }


}
