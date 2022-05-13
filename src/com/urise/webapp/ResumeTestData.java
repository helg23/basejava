package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static com.urise.webapp.model.SectionType.EXPERIENCE;

public class ResumeTestData {
    public static void main(String[] args) {
        Participation w1 = new Participation("01/10/2013", "",
                "Автор проекта",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization o1 = new Organization("Java Online Projects", List.of(w1));

        Participation w2 = new Participation("01/10/2014", "01/01/2016",
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        Organization o2 = new Organization("Wrike", List.of(w2));

        Participation w3 = new Participation("01/04/2012", "01/10/2014",
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        Organization o3 = new Organization("RIT Center", List.of(w3));

        Participation w4 = new Participation("01/12/2010", "01/04/2012",
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        Organization o4 = new Organization("Luxoft (Deutsche Bank)", List.of(w4));

        Participation w5 = new Participation("01/06/2008", "01/12/2010",
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        Organization o5 = new Organization("Yota", List.of(w5));

        Participation w6 = new Participation("01/03/2007", "01/06/2008",
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        Organization o6 = new Organization("Enkata", List.of(w6));

        Participation w7 = new Participation("01/01/2005", "01/02/2007",
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        Organization o7 = new Organization("Siemens AG", List.of(w7));


        Participation w8 = new Participation("01/09/1997", "01/01/2005",
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Organization o8 = new Organization("Alcatel", List.of(w8));

        Resume r = new Resume("Григорий Кислин");
        ParticipationListSection section = new ParticipationListSection(EXPERIENCE.getTitle(),List.of(o1,o2,o3,o4,o5,o6,o7,o8));
        EnumMap<SectionType, AbstractSection> sections =  new EnumMap(Map.of(EXPERIENCE,section));
        r.setSections(sections);

        r.print();
    }
}
