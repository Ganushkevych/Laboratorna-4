package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
//Основна теорія
//Бін це просто об`єкт, що керується спрінгом. При запуску програми біни автоматично інжектяться в DI контейнери
//Scope в Spring - це те що визначає життєвий цикл об'єкта.
//За замовчуванням Singleton(всі запити на об'єкт повертають той самий перший об'єкт)
//Також є Prototype(кожен запит повертає новий екземпляр)
//Inject в Spring - це автоматична ін'єкція залежності
//Існує кілька способів виконання ін'єкції залежностей:
//Через конструктор,
//Через сеттер: контейнер Spring викликає сеттери з залежностями
//Через поле: залежності ін'єктуються в поля за допомогою анотацій(Autowired...)
//Через метод: залежності передаються через методи класу. Контейнер Spring викликає ці методи з переданими параметрами

