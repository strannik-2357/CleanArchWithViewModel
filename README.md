# CleanArchWithViewModel

Примерная архитектуры моих проектов

Приложение разбито на три слоя - PRESENTATION, DOMAIN, DATA

Слой PRESENTATION с использованием SingleActivity + Fragments + ViewModel, подключен ViewBinding, в списках - RecyclerView.  
Навигация c помощью NavigationComponent.

Слой DOMAIN - бизнес-логика - чистый Котлин, классы юзкейсов, доменные модели, мапперы, интерфейсы репозиториев для слоя DATA

DATA слой - на каждую сущность используются отдельные Repository, 
и еще каждые Repository разделен на разные Source, которыми манипулирует сам Репозиторий. 
Данные для локального хранилища (Room SQLite), 
для удаленного хранилища запросы к серверу по REST API через Retrofit. 
Модели разные, чтобы не смешивать аннотации Room и Json. 

Обмазано RxJava :)
